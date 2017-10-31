package com.senla.ebookshop.model;

import com.senla.ebookshop.model.orderstatus.OrderStatus;

import java.time.LocalDate;

public class Order extends Entity{
    private int id;
    private Book book;
    private double price;
    private LocalDate submissionDate;
    private LocalDate executionDate;
    private OrderStatus orderStatus = OrderStatus.PERFORMED;

    public Order(Book book, LocalDate submissionDate, LocalDate executionDate) {
        this.book = book;
        this.price = book.getPrice();
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
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order: " +
                "id= " + id +
                ", book id= " + book.getId() +
                ", price= " + price +
                ", submissionDate= " + submissionDate +
                ", executionDate= " + executionDate +
                ", order status= " + orderStatus;
    }
}
