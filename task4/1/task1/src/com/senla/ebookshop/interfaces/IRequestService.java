package com.senla.ebookshop.interfaces;

import com.senla.ebookshop.model.Request;

import java.util.Comparator;

public interface IRequestService {

    Request[] getAllRequests();

    void addRequest(Request request);

    void deleteRequest(int id);

    Request getRequest(int id);

    void refreshOrderArray();

    Request[] sortRequests(Comparator comparator, Request[] requestsArray);

}
