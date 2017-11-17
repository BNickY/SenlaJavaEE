package com.senla.bookshop.services;

import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.repositories.IOrderRepository;
import com.senla.bookshop.api.services.IOrderService;
import com.senla.bookshop.repositories.BookRepository;
import com.senla.bookshop.repositories.OrderRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService implements IOrderService {
    private IOrderRepository orderRepository;
    private List<IOrder> performedOrders;

    public OrderService(){
        orderRepository = OrderRepository.getInstance();
        performedOrders = new ArrayList<>();
    }

    @Override
    public List<IOrder> getAllOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public void addOrder(IOrder order, double price) {
        order.setPrice(price);
        order.setSubmissionDate(LocalDate.now());
        order.setExecutionDate(order.getSubmissionDate());
        order.setOrderStatus(OrderStatus.ACCEPTED);
        orderRepository.addOrder(order);
    }

    @Override
    public void cancelOrder(long id) {
        IOrder order = orderRepository.getOrder(id);
        order.setOrderStatus(OrderStatus.CANCELED);
        order.setExecutionDate(LocalDate.now());
    }

    @Override
    public IOrder getOrder(long id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public List<IOrder> getPerformedOrders() {
        return performedOrders;
    }

    @Override
    public List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate) {
        List<IOrder> orders = getAllOrders();
        for (IOrder order : orders) {
            if (order != null && (order.getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    order.getExecutionDate().isAfter(startDate) &
                    order.getExecutionDate().isBefore(endDate)))
                performedOrders.add(order);
        }
        return performedOrders;
    }

    @Override
    public double getEarnedMoney(LocalDate startDate, LocalDate endDate) {
        List<IOrder> orders = getAllOrders();
        double sum = 0;
        for (IOrder order : orders) {
            if (order != null && (order.getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    order.getExecutionDate().isAfter(startDate) &
                    order.getExecutionDate().isBefore(endDate)))
                sum += order.getPrice();
        }
        return sum;
    }

    @Override
    public int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate) {
        List<IOrder> orders = getAllOrders();
        int amount = 0;
        for (IOrder order : orders) {
            if (order != null && (order.getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    order.getExecutionDate().isAfter(startDate) &
                    order.getExecutionDate().isBefore(endDate)))
                amount++;
        }
        return amount;
    }

    @Override
    public void completeAnOrder(long id) {
        IOrder order = getOrder(id);
        BookRepository bookRepository = BookRepository.getInstance();
        order.setExecutionDate(LocalDate.now());
        if(bookRepository.getBook(order.getBookId()).getInStoke()){
            bookRepository.getBook(order.getBookId()).setInStoke(false);
            order.setOrderStatus(OrderStatus.PERFORMED);
        }else{
            order.setOrderStatus(OrderStatus.CANCELED);
        }
    }

    @Override
    public void saveToFile() {
        orderRepository.saveToFile();
    }

    @Override
    public void readFromFile() {
        orderRepository.readFromFile();
    }

    @Override
    public List<IOrder> sortOrders(Comparator<IOrder> comparator, List<IOrder> orderList) {
        List<IOrder> orders = new ArrayList<>(orderList);
        orders.sort(comparator);
        return orders;
    }
}