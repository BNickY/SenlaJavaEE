package com.senla.bookshop.entities;

import com.senla.bookshop.api.entities.IBook;
import java.io.Serializable;
import java.time.LocalDate;

public class Book implements IBook, Serializable{

    private static final long serialVersionUID = 2932823076071572959L;
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
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        result = 31 * result + author.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + publishDate.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return Double.compare(book.price, price) == 0 &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                publishDate.equals(book.publishDate);
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
