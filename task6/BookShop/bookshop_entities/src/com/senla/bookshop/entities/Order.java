package com.senla.bookshop.entities;

import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class Order implements Cloneable,IOrder,Serializable{

    private static final long serialVersionUID = 2652367136138174329L;
    private long id;
    private long bookId;
    private double price;
    private LocalDate submissionDate;
    private LocalDate executionDate;
    private OrderStatus orderStatus;

    public Order(long bookId) {
        this.bookId = bookId;
    }

    public Order(long id, long bookId, double price,
                 LocalDate submissionDate, LocalDate executionDate, OrderStatus orderStatus) {
        this.id = id;
        this.bookId = bookId;
        this.price = price;
        this.submissionDate = submissionDate;
        this.executionDate = executionDate;
        this.orderStatus = orderStatus;
    }

    public long getBookId() {
        return bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Order clone() throws CloneNotSupportedException {
        return (Order)super.clone();
    }

    @Override
    public String toString() {
        return "Order {" +
                "id: " + id +
                ", book id: " + bookId +
                ", price: " + price +
                ", submission date: " + submissionDate +
                ", execution date: " + executionDate +
                ", order status: " + orderStatus +
                '}';
    }
}