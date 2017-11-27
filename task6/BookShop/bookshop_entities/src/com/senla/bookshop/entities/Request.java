package com.senla.bookshop.entities;

import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.entities.requeststatus.RequestStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class Request implements IRequest,Serializable{

    private static final long serialVersionUID = -7861950013080053702L;
    private long id;
    private long bookId;
    private LocalDate requestDate;
    private RequestStatus requestStatus;

    public Request(long bookId) {
        this.bookId = bookId;
    }

    public Request(long id, long bookId, LocalDate requestDate, RequestStatus requestStatus) {
        this.id = id;
        this.bookId = bookId;
        this.requestDate = requestDate;
        this.requestStatus = requestStatus;
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

    public long getBookId() {
        return bookId;
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
        return "Request {" +
                "id: " + id +
                ", bookId: " + bookId +
                ", request date: " + requestDate +
                ", request status: " + requestStatus +
                '}';
    }
}
