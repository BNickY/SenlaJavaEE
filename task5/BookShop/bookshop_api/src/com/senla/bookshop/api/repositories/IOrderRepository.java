package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IOrder;
import java.util.List;

public interface IOrderRepository {

    List<IOrder> getOrders();

    void addOrder(IOrder order);

    IOrder getOrder(long id);

    void saveToFile();

    void readFromFile();
}