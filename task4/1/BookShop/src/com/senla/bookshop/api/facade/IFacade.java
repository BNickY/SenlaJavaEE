package com.senla.bookshop.api.facade;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;

import java.time.LocalDate;

public interface IFacade {

    void addBook(Book book);
    void deleteBook(long id);
    Book getBook(long id);
    void getAllBooks();
    void showUnsoldBooks();

    void sortBooksByPrice();
    void sortBooksByTitle();
    void sortBooksByPublishDate();
    void sortBooksByExistenceInStoke();

    void sortUnsoldBooksByPrice();
    void sortUnsoldBooksByReceiptDate();


    void addOrder(Order order);
    void deleteOrder(long id);
    Order getOrder(long id);
    void showAllOrders();
    void showPerformedOrders(LocalDate startDate, LocalDate endDate);
    void showEarnedMoney(LocalDate startDate, LocalDate endDate);
    void showAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);
    void completeAnOrder(Order order);

    void sortOrdersByPrice();
    void sortOrdersByStatus();
    void sortOrdersByExecutionDate();

    void sortPerformedOrdersByDate();
    void sortPerformedOrdersByPrice();

    void showAllRequests();
    void addRequest(Request request);

    void sortRequestsByAlphabet();
    void sortRequestsByAmount();
}
