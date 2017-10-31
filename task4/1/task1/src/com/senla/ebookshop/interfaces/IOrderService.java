package com.senla.ebookshop.interfaces;
import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.repositories.BookRepository;

import java.time.LocalDate;
import java.util.Comparator;

public interface IOrderService {

    Order[] getAllOrders();

    void addOrder(Order order);

    void deleteOrder(int id);

    Order getOrder(int id);

    void refreshOrderArray();

    Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate);

    double getEarnedMoney(LocalDate startDate, LocalDate endDate);

    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);

    void completeAnOrder(Order order, BookRepository bookRepository);

    Order[] sortOrders(Comparator comparator, Order[] ordersArray);
}
