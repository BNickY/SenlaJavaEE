package com.senla.bookshop.api.services;

import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.exeptions.FormatException;

import java.io.IOException;
import java.util.List;

public interface IRequestService {

    List<IRequest> getAllRequests();

    boolean addRequest(IRequest request);

    void cancelRequest(long id);

    IRequest getRequest(long id);

    List<IRequest> sortRequestsByAlphabet();

    List<IRequest> sortRequestsByAmount();

    void setRequests(List<IRequest> requests);

    void exportRequests(String file) throws IOException;

    void importRequests(String file) throws IOException, FormatException;
}
