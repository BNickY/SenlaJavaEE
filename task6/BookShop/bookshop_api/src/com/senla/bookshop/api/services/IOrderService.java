package com.senla.bookshop.api.services;

import com.senla.bookshop.api.entities.IOrder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public interface IOrderService {

    List<IOrder> getAllOrders();

    void addOrder(IOrder order, double price);

    void cancelOrder(long id);

    IOrder getOrder(long id);

    List<IOrder> getPerformedOrders();

    List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate);

    double getEarnedMoney(LocalDate startDate, LocalDate endDate);

    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);

    void completeAnOrder(long id);

    List<IOrder> sortOrders(Comparator<IOrder> comparator, List<IOrder> orderList);

    void setOrders(List<IOrder> orders);

    void exportOrders(String file) throws IOException;

    void importOrders(String file) throws IOException;
}
