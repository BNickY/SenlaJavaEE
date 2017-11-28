package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IOrder;

import java.io.IOException;
import java.util.List;

public interface IOrderRepository {

    List<IOrder> getOrders();

    void addOrder(IOrder order);

    IOrder getOrder(long id);

    void setOrders(List<IOrder> orders);

    void exportOrders(String file) throws IOException;

    void importOrders(String file) throws IOException;
}