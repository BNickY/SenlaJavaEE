package com.senla.bookshop.services;

import com.senla.bookshop.api.services.IRequestService;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.repositories.RequestRepository;

import java.util.Arrays;
import java.util.Comparator;

public class RequestService implements IRequestService{
    private RequestRepository requestRepository;

    public RequestService(){
        requestRepository = new RequestRepository();
    }


    @Override
    public Request[] getAllRequests() {
        return requestRepository.getAllRequests();
    }

    @Override
    public void addRequest(Request request) {
        requestRepository.addRequest(request);
    }

    @Override
    public void deleteRequest(long id) {
        requestRepository.deleteRequest(id);
    }

    @Override
    public Request getRequest(long id) {
        return requestRepository.getRequest(id);
    }

    @Override
    public void saveToFile() {
        requestRepository.saveToFile();
    }

    @Override
    public void readFromFile() {
        requestRepository.readFromFile();
    }

    @Override
    public Request[] sortRequests(Comparator<Request> comparator) {
        Request[] requestsArray = Arrays.copyOf(getAllRequests(),getAllRequests().length);
        Arrays.sort(requestsArray, comparator);
        return requestsArray;
    }
}
