package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.repositories.IOrderRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository{
    private static OrderRepository orderRepository;
    private List<IOrder> orders = new ArrayList<>();
    private static long nextId = 0;

    private OrderRepository(){}

    public static synchronized OrderRepository getInstance(){
        if(orderRepository == null)
            orderRepository = new OrderRepository();

        return orderRepository;
    }

    public List<IOrder> getOrders(){
        return orders;
    }

    public void addOrder(IOrder order){
        order.setId(nextId);
        nextId++;
        orders.add(order);
    }

    public IOrder getOrder(long id){
        for(IOrder order : orders)
            if(order.getId() == id) return order;
        return null;
    }

    @Override
    public void setOrders(List<IOrder> orders) {
        this.orders = orders;
        if(this.orders.size() > 0)
            nextId = this.orders.get(this.orders.size()-1).getId() + 1;
    }

    @Override
    public void exportOrders(String file) throws IOException {
        TextFileUtil.writeDataToFile(Converter.entitiesToStrings(orders),file);
    }

    @Override
    public void importOrders(String file) throws IOException {
        List<IOrder> ordersToAdd = Converter.stringsToOrders(TextFileUtil.readDataFromFile(file));
        for (IOrder order : ordersToAdd) {
            IOrder addedOrder = getOrder(order.getId());
            if (addedOrder != null) {
                orders.set(orders.indexOf(addedOrder),order);
            } else {
                addOrder(order);
            }
        }
    }
}
