package com.senla.bookshop.services;

import com.senla.bookshop.api.services.IOrderService;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.orderstatus.OrderStatus;
import com.senla.bookshop.repositories.OrderRepository;
import com.senla.bookshop.utils.ArrayWorker;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class OrderService implements IOrderService{
    private OrderRepository orderRepository;
    private Order[] performedOrders;

    public OrderService(){
        orderRepository = new OrderRepository();
        performedOrders = new Order[0];
    }

    @Override
    public Order[] getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public Order getOrder(long id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate) {
        Order[] orders = getAllOrders();
        performedOrders = new Order[orders.length];
        for(int i = 0; i < orders.length; i++){
           if(orders[i] != null && (orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate)))
                performedOrders[i] = orders[i];
            else performedOrders[i] = null;
        }
        performedOrders = (Order[]) ArrayWorker.compressArray(performedOrders);
        return performedOrders;
    }

    @Override
    public double getEarnedMoney(LocalDate startDate, LocalDate endDate) {
        Order[] orders = getAllOrders();
        double sum = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i] != null && (orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate)))
                sum += orders[i].getPrice();
        }
        return sum;
    }

    @Override
    public int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate) {
        Order[] orders = getAllOrders();
        int amount = 0;
        for(int i = 0; i < orders.length; i++){
            if(orders[i] != null && (orders[i].getOrderStatus().compareTo(OrderStatus.PERFORMED) == 0 &
                    orders[i].getExecutionDate().isAfter(startDate) &
                    orders[i].getExecutionDate().isBefore(endDate)))
                amount++;
        }
        return amount;
    }

    @Override
    public void completeAnOrder(Order order, BookService bookService) {
        if(bookService.getBook(order.getBook().getId()).getInStoke()){
            bookService.getBook(order.getBook().getId()).setInStoke(false);
            order.setOrderStatus(OrderStatus.PERFORMED);
        }else{
            order.setOrderStatus(OrderStatus.CANCELED);
        }
    }

    @Override
    public Order[] sortAllOrders(Comparator<Order> comparator) {
        Order[] ordersArray = Arrays.copyOf(getAllOrders(),getAllOrders().length);
        Arrays.sort(ordersArray, comparator);
        return ordersArray;
    }

    @Override
    public Order[] sortPerformedOrders(Comparator<Order> comparator) {
            Order[] ordersArray = performedOrders;
            Arrays.sort(ordersArray, comparator);
            return ordersArray;
    }

    @Override
    public void saveToFile() {
        orderRepository.saveToFile();
    }

    @Override
    public void readFromFile() {
        orderRepository.readFromFile();
    }
}
