package com.senla.bookshop.entities;

import java.time.LocalDate;

public class Book extends Entity{

    private long id;
    private String title;
    private String author;
    private double price;
    private Boolean inStoke;
    private LocalDate publishDate;
    private LocalDate receiptDate;
    private int amountOfRequests;


    public Book(String title, String author, double price, LocalDate publishDate, LocalDate receiptDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.receiptDate = receiptDate;
        this.amountOfRequests = 0;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getInStoke() {
        return inStoke;
    }

    public void setInStoke(Boolean inStoke) {
        this.inStoke = inStoke;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getAmountOfRequests() {
        return amountOfRequests;
    }

    public void setAmountOfRequests(int amountOfRequests) {
        this.amountOfRequests = amountOfRequests;
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
        return "id:" + id +
                ", title:" + title +
                ", author:" + author +
                ", price:" + price +
                ", in stock:" + inStoke +
                ", publish date:" + publishDate +
                ", receipt date:" + receiptDate +
                ", amount of requests:" + amountOfRequests;
    }
}
