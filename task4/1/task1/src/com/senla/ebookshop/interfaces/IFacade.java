package com.senla.ebookshop.interfaces;

import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.model.Request;
import java.time.LocalDate;

public interface IFacade{

    Book[] getAllBooks();

    void addBook(Book book);

    void deleteBook(int id);

    Book getBook(int id);

    Book[] getUnsoldBooks();

    Book[] sortBooksByTitle(Book[] booksArray);

    Book[] sortBooksByPrice(Book[] booksArray);

    Book[] sortBooksByPublishDate(Book[] booksArray);

    Book[] sortBooksByReceiptDate(Book[] booksArray);

    Book[] sortBooksByExistenceInStoke(Book[] booksArray);

    Order[] getAllOrders();

    void addOrder(Order order);

    void deleteOrder(int id);

    Order getOrder(int id);

    Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate);

    double getEarnedMoney(LocalDate startDate, LocalDate endDate);

    int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate);

    void completeAnOrder(Order order);

    Order[] sortOrdersByExecutionDate(Order[] ordersArray);

    Order[] sortOrdersByPrice(Order[] ordersArray);

    Order[] sortOrdersByStatus(Order[] ordersArray);

    Request[] getAllRequests();

    void addRequest(Request request);

    Request[] sortRequestByAlphabet(Request[] requestsArray);

    Request[] sortByAmountOfRequests(Request[] requestsArray);
}