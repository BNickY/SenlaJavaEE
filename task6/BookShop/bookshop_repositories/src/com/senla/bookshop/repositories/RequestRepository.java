package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.api.repositories.IRequestRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestRepository implements IRequestRepository{
    private static RequestRepository requestRepository;
    private List<IRequest> requests = new ArrayList<>();
    private static long nextId = 0;

    private RequestRepository(){}

    public static RequestRepository getInstance(){
        if(requestRepository == null)
            requestRepository = new RequestRepository();
        return requestRepository;
    }

    public List<IRequest> getRequests(){
        return requests;
    }

    public void addRequest(IRequest request){
        request.setId(nextId);
        nextId++;
        requests.add(request);
    }

    public IRequest getRequest(long id){
        for(IRequest request : requests)
            if(request.getId() == id) return request;
        return null;
    }

    @Override
    public void setRequests(List<IRequest> requests) {
        this.requests = requests;
        if(this.requests.size() > 0)
            nextId = this.requests.get(this.requests.size()-1).getId() + 1;
    }

    @Override
    public void exportRequests(String file) throws IOException {
        TextFileUtil.writeDataToFile(Converter.entitiesToStrings(requests),file);
    }

    @Override
    public void importRequests(String file) throws IOException, FormatException {
        List<IRequest> requestsToAdd = Converter.stringsToRequests(TextFileUtil.readDataFromFile(file));
        for (IRequest request : requestsToAdd) {
            IRequest addedRequest = getRequest(request.getId());
            if (addedRequest != null) {
                requests.set(requests.indexOf(addedRequest),request);
            } else {
                addRequest(request);
            }
        }
    }
}
