package com.senla.ebookshop.services;

import com.senla.ebookshop.comparators.request.RequestAlphabetComparator;
import com.senla.ebookshop.comparators.request.RequestAmountComparator;
import com.senla.ebookshop.interfaces.IRequestService;
import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.repositories.RequestRepository;

import java.util.Comparator;

public class RequestService implements IRequestService{
    private RequestRepository requestRepository = new RequestRepository();

    @Override
    public Request[] getAllRequests() {
        return requestRepository.getAllRequests();
    }

    @Override
    public void addRequest(Request request) {
        requestRepository.addRequest(request);
    }

    @Override
    public void deleteRequest(int id) {
        requestRepository.deleteRequest(id);
    }

    @Override
    public Request getRequest(int id) {
        return requestRepository.getRequest(id);
    }

    @Override
    public void refreshOrderArray() {
        requestRepository.refreshOrderArray();
    }

    @Override
    public Request[] sortRequests(Comparator comparator, Request[] requestsArray) {
        if(RequestAlphabetComparator.class == comparator.getClass()){
            return requestRepository.sortRequestByAlphabet(requestsArray);
        }
        else if(RequestAmountComparator.class == comparator.getClass()){
            return requestRepository.sortByAmountOfRequests(requestsArray);
        }
        else return null;
    }

    public RequestRepository getRequestRepository() {
        return requestRepository;
    }
}
