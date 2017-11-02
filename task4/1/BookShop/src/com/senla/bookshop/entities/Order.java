package com.senla.bookshop.entities;

import com.senla.bookshop.entities.orderstatus.OrderStatus;

import java.time.LocalDate;

public class Order extends Entity {

    private long id;
    private Book book;
    private double price;
    private LocalDate submissionDate;
    private LocalDate executionDate;
    private OrderStatus orderStatus;

    public Order(Book book, LocalDate submissionDate, LocalDate executionDate) {
        this.book = book;
        this.submissionDate = submissionDate;
        this.executionDate = executionDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
    public String toString() {
        return  "id:" + id +
                ", book id:" + book.getId() +
                ", price:" + price +
                ", submission date:" + submissionDate +
                ", execution date:" + executionDate +
                ", order status: " + orderStatus;
    }
}
