package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.repositories.IRequestRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;
import java.util.ArrayList;
import java.util.List;

public class RequestRepository implements IRequestRepository{
    private static RequestRepository requestRepository;
    private List<IRequest> requests = new ArrayList<>();
    private TextFileUtil fileUtil = new TextFileUtil("requests.txt");
    private static long nextId = 0;

    private RequestRepository(){}

    public static synchronized RequestRepository getInstance(){
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

    public void saveToFile() {
        fileUtil.writeDataToFile(Converter.entitiesToStrings(requests));
    }

    public void readFromFile() {
        requests = Converter.stringsToRequests(fileUtil.readDataFromFile());
        if(requests.size() > 0)
            nextId = requests.get(requests.size()-1).getId() + 1;
    }
}
