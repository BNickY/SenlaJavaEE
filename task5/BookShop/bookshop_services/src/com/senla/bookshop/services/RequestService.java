package com.senla.bookshop.services;

import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.entities.requeststatus.RequestStatus;
import com.senla.bookshop.api.repositories.IRequestRepository;
import com.senla.bookshop.api.services.IRequestService;
import com.senla.bookshop.repositories.BookRepository;
import com.senla.bookshop.repositories.RequestRepository;
import com.senla.bookshop.utils.ComparisonUtil;
import java.time.LocalDate;
import java.util.*;

public class RequestService implements IRequestService {
    private IRequestRepository requestRepository;

    public RequestService(){
        requestRepository = RequestRepository.getInstance();
    }

    @Override
    public List<IRequest> getAllRequests() {
        return requestRepository.getRequests();
    }

    @Override
    public void addRequest(IRequest request) {
        request.setRequestStatus(RequestStatus.ACCEPTED);
        request.setRequestDate(LocalDate.now());
        requestRepository.addRequest(request);
    }

    @Override
    public void cancelRequest(long id) {
        requestRepository.getRequest(id).setRequestStatus(RequestStatus.CANCELED);
    }

    @Override
    public IRequest getRequest(long id) {
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
    public List<IRequest> sortRequestsByAlphabet() {
        BookRepository bookRepository = BookRepository.getInstance();
        List<IRequest> requests = new ArrayList<>(getAllRequests());
        requests.sort((o1, o2) -> {
            int checkValue = ComparisonUtil.compareNullReferences(o1, o2);
            if (checkValue == 2) {
                return bookRepository.getBook(o1.getBookId()).getTitle()
                        .compareToIgnoreCase(bookRepository.getBook(o2.getBookId()).getTitle());
            }
            return checkValue;

        });
        return requests;
    }

    @Override
    public List<IRequest> sortRequestsByAmount() {
        List<IRequest> requests = new ArrayList<>(getAllRequests());
        HashMap<Long,Integer> occurrencesCount = new HashMap<>();
        HashMap<IRequest,Integer> requestsOccurrences = new HashMap<>();

        for (IRequest request : requests) {
            if (occurrencesCount.containsKey(request.getBookId())) {
                Integer count = occurrencesCount.get(request.getBookId());
                occurrencesCount.put(request.getBookId(), ++count);
            } else
                occurrencesCount.put(request.getBookId(), 1);
        }

        for(Long key : occurrencesCount.keySet()){
            for(IRequest request: requests){
                if(request.getBookId() == key){
                    requestsOccurrences.put(request,occurrencesCount.get(key));
                }
            }
        }

        Set<Map.Entry<IRequest, Integer>> set = requestsOccurrences.entrySet();

        ArrayList<Map.Entry<IRequest, Integer>> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            int checkValue = ComparisonUtil.compareNullReferences(o1, o2);
            if (checkValue == 2) {
                if ((o2.getValue()).compareTo(o1.getValue()) == 0)
                    return ((Long.compare(o2.getKey().getBookId(),o1.getKey().getBookId())));
                return o2.getValue().compareTo(o1.getValue());
            }
            return checkValue;
        });

        List<IRequest> output = new ArrayList<>();

        for (Map.Entry<IRequest, Integer> entry : list) {
            output.add(entry.getKey());
        }
        return output;
    }
}
