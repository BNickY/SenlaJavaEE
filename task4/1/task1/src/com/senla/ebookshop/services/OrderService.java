package com.senla.ebookshop.services;

import com.senla.ebookshop.comparators.order.ExecutionDateComparator;
import com.senla.ebookshop.comparators.order.OrderPriceComparator;
import com.senla.ebookshop.comparators.order.OrderStatusComparator;
import com.senla.ebookshop.interfaces.IOrderService;
import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.repositories.BookRepository;
import com.senla.ebookshop.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.Comparator;

public class OrderService implements IOrderService{
    private OrderRepository orderRepository = new OrderRepository();

    @Override
    public Order[] getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public void refreshOrderArray() {
        orderRepository.refreshOrderArray();
    }

    @Override
    public Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate) {
        return orderRepository.getPerformedOrders(startDate,endDate);
    }

    @Override
    public double getEarnedMoney(LocalDate startDate, LocalDate endDate) {
        return orderRepository.getEarnedMoney(startDate,endDate);
    }

    @Override
    public int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate) {
        return orderRepository.getAmountOfPerformedOrders(startDate,endDate);
    }

    @Override
    public void completeAnOrder(Order order, BookRepository bookRepository) {
        orderRepository.completeAnOrder(order,bookRepository);
    }

    @Override
    public Order[] sortOrders(Comparator comparator, Order[] ordersArray) {
        if(ExecutionDateComparator.class == comparator.getClass()){
            return orderRepository.sortOrdersByExecutionDate(ordersArray);
        }
        else if(OrderPriceComparator.class == comparator.getClass()){
            return orderRepository.sortOrdersByPrice(ordersArray);
        }
        else if(OrderStatusComparator.class == comparator.getClass()) {
            return orderRepository.sortOrdersByStatus(ordersArray);
        }
        else return null;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }
}
