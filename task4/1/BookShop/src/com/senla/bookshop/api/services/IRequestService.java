package com.senla.bookshop.api.services;

import com.senla.bookshop.entities.Request;

import java.util.Comparator;

public interface IRequestService {

    Request[] getAllRequests();
    void addRequest(Request request);
    void deleteRequest(long id);
    Request getRequest(long id);
    void saveToFile();
    void readFromFile();
    Request[] sortRequests(Comparator<Request> comparator);
}
