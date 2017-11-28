package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IRequest;

import java.io.IOException;
import java.util.List;

public interface IRequestRepository {

    List<IRequest> getRequests();

    void addRequest(IRequest request);

    IRequest getRequest(long id);

    void setRequests(List<IRequest> requests);

    void exportRequests(String file) throws IOException;

    void importRequests(String file) throws IOException;
}