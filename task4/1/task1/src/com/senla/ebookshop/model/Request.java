package com.senla.ebookshop.model;

import com.senla.ebookshop.model.requeststatus.RequestStatus;

import java.time.LocalDate;

public class Request extends Entity {
    private int id;
    private Book book;
    private LocalDate requestDate;
    private RequestStatus requestStatus;

    public Request(Book book, LocalDate requestDate) {
        this.book = book;
        this.requestDate = requestDate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
        return "Request: " +
                " id= " + id +
                ", book id: " + book.getId() +
                ", book title: " + book.getTitle() +
                ", requestDate: " + requestDate +
                ", requestStatus: " + requestStatus;
    }
}