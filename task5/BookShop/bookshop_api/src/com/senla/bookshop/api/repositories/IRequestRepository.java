package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IRequest;

import java.util.List;

public interface IRequestRepository {

    List<IRequest> getAllRequests();

    void addRequest(IRequest request);

    IRequest getRequest(long id);

    void saveToFile();

    void readFromFile();
}