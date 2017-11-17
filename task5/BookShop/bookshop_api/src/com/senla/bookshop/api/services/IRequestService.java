package com.senla.bookshop.api.services;

import com.senla.bookshop.api.entities.IRequest;
import java.util.List;

public interface IRequestService {

    List<IRequest> getAllRequests();

    void addRequest(IRequest request);

    void cancelRequest(long id);

    IRequest getRequest(long id);

    List<IRequest> sortRequestsByAlphabet();

    List<IRequest> sortRequestsByAmount();

    void saveToFile();

    void readFromFile();
}
