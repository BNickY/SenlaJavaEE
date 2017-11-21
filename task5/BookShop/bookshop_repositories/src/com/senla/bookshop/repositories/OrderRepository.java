package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.repositories.IOrderRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository{
    private static OrderRepository orderRepository;
    private List<IOrder> orders = new ArrayList<>();
    private TextFileUtil fileUtil = new TextFileUtil("orders.txt");
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

    public void saveToFile() {
        fileUtil.writeDataToFile(Converter.entitiesToStrings(orders));
    }

    public void readFromFile() {
        orders = Converter.stringsToOrders(fileUtil.readDataFromFile());
        if(orders.size() > 0)
            nextId = orders.get(orders.size()-1).getId() + 1;
    }
}
