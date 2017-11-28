package com.senla.bookshop.api.facade;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.exeptions.DataNotExistException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IFacade {

    void addBook(IBook book);
    void deleteBook(long id) throws DataNotExistException;
    IBook getBook(long id) throws DataNotExistException;
    List<IBook> getAllBooks() throws DataNotExistException;
    List<IBook> getUnsoldBooks() throws DataNotExistException;
    List<IBook> sortBooksByPrice() throws DataNotExistException;
    List<IBook> sortBooksByTitle() throws DataNotExistException;
    List<IBook> sortBooksByPublishDate() throws DataNotExistException;
    List<IBook> sortBooksByExistenceInStoke() throws DataNotExistException;
    List<IBook> sortUnsoldBooksByPrice() throws DataNotExistException;
    List<IBook> sortUnsoldBooksByReceiptDate() throws DataNotExistException;
    void exportBooks(String file)throws IOException;
    void importBooks(String file)throws IOException;

    void addOrder(IOrder order) throws DataNotExistException;
    void cancelOrder(long id) throws DataNotExistException;
    IOrder getOrder(long id) throws DataNotExistException;
    List<IOrder> getAllOrders() throws DataNotExistException;
    List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate) throws DataNotExistException;
    double getEarnedMoney(LocalDate startDate, LocalDate endDate);
    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);
    void completeAnOrder(long id) throws DataNotExistException;
    List<IOrder> sortOrdersByPrice() throws DataNotExistException;
    List<IOrder> sortOrdersByStatus() throws DataNotExistException;
    List<IOrder> sortOrdersByExecutionDate() throws DataNotExistException;
    List<IOrder> sortPerformedOrdersByDate() throws DataNotExistException;
    List<IOrder> sortPerformedOrdersByPrice() throws DataNotExistException;
    void exportOrders(String file) throws IOException;
    void importOrders(String file) throws IOException;

    List<IRequest> getAllRequests() throws DataNotExistException;
    void addRequest(IRequest request) throws DataNotExistException;
    List<IRequest> sortRequestsByAlphabet() throws DataNotExistException;
    List<IRequest> sortRequestsByAmount() throws DataNotExistException;
    void exportRequests(String file) throws IOException;
    void importRequests(String file) throws IOException;

    void load();
    void exit();
}
