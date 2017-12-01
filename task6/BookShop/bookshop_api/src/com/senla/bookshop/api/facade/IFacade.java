package com.senla.bookshop.api.facade;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IFacade {

    void addBook(IBook book);
    boolean deleteBook(long id);
    IBook getBook(long id);
    List<IBook> getAllBooks();
    List<IBook> getUnsoldBooks();
    List<IBook> sortBooksByPrice();
    List<IBook> sortBooksByTitle();
    List<IBook> sortBooksByPublishDate();
    List<IBook> sortBooksByExistenceInStoke();
    List<IBook> sortUnsoldBooksByPrice();
    List<IBook> sortUnsoldBooksByReceiptDate();
    boolean exportBooks(String file);
    boolean importBooks(String file);

    boolean addOrder(IOrder order);
    boolean cancelOrder(long id);
    IOrder getOrder(long id);
    List<IOrder> getAllOrders();
    List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate);
    double getEarnedMoney(LocalDate startDate, LocalDate endDate);
    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);
    boolean completeAnOrder(long id);
    List<IOrder> sortOrdersByPrice();
    List<IOrder> sortOrdersByStatus();
    List<IOrder> sortOrdersByExecutionDate();
    List<IOrder> sortPerformedOrdersByDate();
    List<IOrder> sortPerformedOrdersByPrice();
    boolean exportOrders(String file);
    boolean importOrders(String file);

    List<IRequest> getAllRequests();
    boolean addRequest(IRequest request);
    List<IRequest> sortRequestsByAlphabet();
    List<IRequest> sortRequestsByAmount();
    boolean exportRequests(String file) throws IOException;
    boolean importRequests(String file) throws IOException;

    boolean load();
    boolean exit();
}
