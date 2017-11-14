package com.senla.bookshop.entities;

import com.senla.bookshop.api.entities.IBook;
import java.time.LocalDate;

public class Book implements IBook{

    private long id;
    private String title;
    private String author;
    private double price;
    private Boolean inStoke;
    private LocalDate publishDate;
    private LocalDate receiptDate;

    public Book(String title, String author, double price, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
    }

    public Book(long id, String title, String author, double price,
                Boolean inStoke, LocalDate publishDate, LocalDate receiptDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.inStoke = inStoke;
        this.publishDate = publishDate;
        this.receiptDate = receiptDate;
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

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!Book.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Book other = (Book) obj;

        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title))
            return false;

        if (Double.compare(this.price,other.price) != 0 )
            return false;

        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author))
            return false;

        if(!this.publishDate.isEqual(other.getPublishDate()))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id: " + id +
                ", title: '" + title + '\'' +
                ", author: '" + author + '\'' +
                ", price: " + price +
                ", in stoke:" + inStoke +
                ", publish date: " + publishDate +
                ", receipt date: " + receiptDate +
                '}';
    }
}
