package com.senla.bookshop.api.entities;

import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import java.time.LocalDate;

public interface IOrder extends IEntity{

    long getBookId();

    void setBookId(long bookId);

    double getPrice();

    void setPrice(double price);

    LocalDate getSubmissionDate();

    void setSubmissionDate(LocalDate submissionDate);

    LocalDate getExecutionDate();

    void setExecutionDate(LocalDate executionDate);

    OrderStatus getOrderStatus();

    void setOrderStatus(OrderStatus orderStatus);
}
