package com.senla.bookshop.repositories;

import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.requeststatus.RequestStatus;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.TextFileUtil;
import com.senla.bookshop.utils.TextParser;

public class RequestRepository {
    private static final String filePath = "data_files/requests.txt";
    private TextFileUtil textFileUtil = new TextFileUtil(filePath);
    private Request[] requests;
    private static long nextId = 0;

    public RequestRepository() {
        requests = new Request[ArrayWorker.START_SIZE];
    }

    public Request[] getAllRequests(){
        return requests;
    }

    public void addRequest(Request request){
        if(!ArrayWorker.hasEmptySpace(requests))
            requests = (Request []) ArrayWorker.expandArray(requests);

        int position = ArrayWorker.getNextFreePosition(requests);
        request.setId(nextId);
        nextId++;
        request.getBook().setAmountOfRequests(request.getBook().getAmountOfRequests() + 1);
        request.setRequestStatus(RequestStatus.ACCEPTED);
        requests[position] = request;
    }

    public void deleteRequest(long id){
        for (int i = 0; i < requests.length; i++)
            if(requests[i] != null && requests[i].getId() == id)
                requests[i].setRequestStatus(RequestStatus.CANCELED);
    }

    public Request getRequest(long id){
        return (Request) ArrayWorker.findById(requests,id);
    }

    public void saveToFile(){
        requests = (Request[]) ArrayWorker.compressArray(requests);
        textFileUtil.writeDataToFile(TextParser.parseEntities(requests));
    }

    public void readFromFile(){
        requests = TextParser.parseRequsestStrings(textFileUtil.readDataFromFile());
        nextId = requests[requests.length-1].getId() + 1;
    }
}
