package com.senla.bookshop.api.services;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.services.BookService;

import java.time.LocalDate;
import java.util.Comparator;

public interface IOrderService {

    Order[] getAllOrders();
    void addOrder(Order order);
    void deleteOrder(long id);
    Order getOrder(long id);
    Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate);
    double getEarnedMoney(LocalDate startDate, LocalDate endDate);
    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);
    void completeAnOrder(Order order, BookService bookService);
    Order[] sortAllOrders(Comparator<Order> comparator);
    Order[] sortPerformedOrders(Comparator<Order> comparator);
    void saveToFile();
    void readFromFile();
}
