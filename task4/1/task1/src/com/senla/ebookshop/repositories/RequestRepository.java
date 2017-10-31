package com.senla.ebookshop.repositories;

import com.senla.ebookshop.comparators.request.RequestAlphabetComparator;
import com.senla.ebookshop.comparators.request.RequestAmountComparator;
import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.model.requeststatus.RequestStatus;
import com.senla.ebookshop.utils.ArrayWorker;
import com.senla.ebookshop.utils.Printer;

import java.util.*;

public class RequestRepository {
    private Request[] requests = new Request[ArrayWorker.getStartSize()];
    private static int id = 0;

    public Request[] getAllRequests(){
        return requests;
    }

    public void addRequest(Request request){
        if(!ArrayWorker.hasEmptySpace(requests))
            requests = (Request []) ArrayWorker.expandArray(requests);

        int position = ArrayWorker.getNextFreePosition(requests);
        request.setId(id);
        id++;
        request.setRequestStatus(RequestStatus.ACCEPTED);
        request.getBook().setAmountOfRequests(request.getBook().getAmountOfRequests() + 1);
        requests[position] = request;
    }

    public void deleteRequest(int id){
        for (int i = 0; i < requests.length; i++)
            if(requests[i] != null && requests[i].getId() == id)
                requests[i].setRequestStatus(RequestStatus.CANCELED);
    }

    public Request getRequest(int id){
        return (Request) ArrayWorker.findById(requests,id);
    }

    public void refreshOrderArray(){
        requests = (Request[]) ArrayWorker.compressArray(requests);
    }

    public Request[] sortRequestByAlphabet(Request[] requestsArray){
        Arrays.sort(requestsArray, new RequestAlphabetComparator());
        Printer.printMessage("Sorted by alphabet");
        return requestsArray;
    }

    public Request[] sortByAmountOfRequests(Request[] requestsArray){
        Arrays.sort(requestsArray, new RequestAmountComparator().reversed());
        Printer.printMessage("Sorted by amount of requests");
        return requestsArray;
    }
}
