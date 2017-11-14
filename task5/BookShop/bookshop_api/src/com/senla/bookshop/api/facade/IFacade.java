package com.senla.bookshop.api.facade;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import java.time.LocalDate;
import java.util.List;

public interface IFacade {

    void addBook(IBook book);
    void deleteBook(long id);
    IBook getBook(long id);
    List<IBook> getAllBooks();
    List<IBook> getUnsoldBooks();
    List<IBook> sortBooksByPrice();
    List<IBook> sortBooksByTitle();
    List<IBook> sortBooksByPublishDate();
    List<IBook> sortBooksByExistenceInStoke();
    List<IBook> sortUnsoldBooksByPrice();
    List<IBook> sortUnsoldBooksByReceiptDate();


    void addOrder(IOrder order);
    void cancelOrder(long id);
    IOrder getOrder(long id);
    List<IOrder> getAllOrders();
    List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate);
    double getEarnedMoney(LocalDate startDate, LocalDate endDate);
    int showAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);
    void completeAnOrder(long id);
    List<IOrder> sortOrdersByPrice();
    List<IOrder> sortOrdersByStatus();
    List<IOrder> sortOrdersByExecutionDate();
    List<IOrder> sortPerformedOrdersByDate();
    List<IOrder> sortPerformedOrdersByPrice();

    List<IRequest> getAllRequests();
    void addRequest(IRequest request);
    List<IRequest> sortRequestsByAlphabet();
    List<IRequest> sortRequestsByAmount();
}
