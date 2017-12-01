package com.senla.bookshop.services;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.api.repositories.IOrderRepository;
import com.senla.bookshop.api.services.IOrderService;
import com.senla.bookshop.repositories.BookRepository;
import com.senla.bookshop.repositories.OrderRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService implements IOrderService {
    private IOrderRepository orderRepository;
    private List<IOrder> performedOrders;

    public OrderService(){
        orderRepository = OrderRepository.getInstance();
    }

    @Override
    public List<IOrder> getAllOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public boolean addOrder(IOrder order) {
        IBook book = BookRepository.getInstance().getBook(order.getBookId());
        if(book != null && book.getInStoke()) {
            if (order.getId() != -1) {
                order.setPrice(book.getPrice());
                order.setSubmissionDate(LocalDate.now());
                order.setExecutionDate(order.getSubmissionDate());
                order.setOrderStatus(OrderStatus.ACCEPTED);
            }
            orderRepository.addOrder(order);
            return true;
        }else
            return false;
    }

    @Override
    public boolean cancelOrder(long id) {
        IOrder order = orderRepository.getOrder(id);
        if(order != null) {
            if(order.getOrderStatus() == OrderStatus.ACCEPTED){
                order.setOrderStatus(OrderStatus.CANCELED);
                order.setExecutionDate(LocalDate.now());
                return true;
            }
        }
        return false;
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
        performedOrders = new ArrayList<>();
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
    public boolean completeAnOrder(long id) {
        IOrder order = getOrder(id);
        if(order != null && order.getOrderStatus() == OrderStatus.ACCEPTED) {
            BookRepository bookRepository = BookRepository.getInstance();
            order.setExecutionDate(LocalDate.now());
            if (bookRepository.getBook(order.getBookId()).getInStoke()) {
                bookRepository.getBook(order.getBookId()).setInStoke(false);
                order.setOrderStatus(OrderStatus.PERFORMED);
            } else {
                order.setOrderStatus(OrderStatus.CANCELED);
            }
            return true;
        }else
            return false;
    }


    @Override
    public List<IOrder> sortOrders(Comparator<IOrder> comparator, List<IOrder> orderList) {
        List<IOrder> orders = new ArrayList<>(orderList);
        orders.sort(comparator);
        return orders;
    }

    @Override
    public void setOrders(List<IOrder> orders) {
        orderRepository.setOrders(orders);
    }

    @Override
    public void exportOrders(String file) throws IOException {
        orderRepository.exportOrders(file);
    }

    @Override
    public void importOrders(String file) throws IOException, FormatException {
        orderRepository.importOrders(file);
    }
}