package com.senla.ebookshop.facade;

import com.senla.ebookshop.comparators.book.*;
import com.senla.ebookshop.comparators.order.ExecutionDateComparator;
import com.senla.ebookshop.comparators.order.OrderPriceComparator;
import com.senla.ebookshop.comparators.order.OrderStatusComparator;
import com.senla.ebookshop.comparators.request.RequestAlphabetComparator;
import com.senla.ebookshop.comparators.request.RequestAmountComparator;
import com.senla.ebookshop.interfaces.IFacade;
import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.services.BookService;
import com.senla.ebookshop.services.OrderService;
import com.senla.ebookshop.services.RequestService;

import java.time.LocalDate;

public class Facade implements IFacade{
    private BookService bookService = new BookService();
    private OrderService orderService = new OrderService();
    private RequestService requestService = new RequestService();

    @Override
    public Book[] getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookService.addBook(book,requestService.getAllRequests());
    }

    @Override
    public void deleteBook(int id) {
        bookService.deleteBook(id);
    }

    @Override
    public Book getBook(int id) {
        return bookService.getBook(id);
    }

    @Override
    public Book[] getUnsoldBooks() {
        return bookService.getUnsoldBooks();
    }

    @Override
    public Book[] sortBooksByTitle(Book[] booksArray) {
        return bookService.sortBooks(new TitleComparator(),booksArray);
    }

    @Override
    public Book[] sortBooksByPrice(Book[] booksArray) {
        return bookService.sortBooks(new BookPriceComparator(),booksArray);
    }

    @Override
    public Book[] sortBooksByPublishDate(Book[] booksArray) {
        return bookService.sortBooks(new PublishDateComparator(),booksArray);
    }

    @Override
    public Book[] sortBooksByReceiptDate(Book[] booksArray) {
        return bookService.sortBooks(new ReceiptDateComparator(),booksArray);
    }

    @Override
    public Book[] sortBooksByExistenceInStoke(Book[] booksArray) {
        return bookService.sortBooks(new InStokeComparator(),booksArray);
    }

    @Override
    public Order[] getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderService.deleteOrder(id);
    }

    @Override
    public Order getOrder(int id) {
        return orderService.getOrder(id);
    }

    @Override
    public Order[] getPerformedOrders(LocalDate startDate, LocalDate endDate) {
        return orderService.getPerformedOrders(startDate,endDate);
    }

    @Override
    public double getEarnedMoney(LocalDate startDate, LocalDate endDate) {
        return orderService.getEarnedMoney(startDate,endDate);
    }

    @Override
    public int getAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate) {
        return orderService.getAmountOfPerformedOrders(startDate,endDate);
    }

    @Override
    public void completeAnOrder(Order order) {
        orderService.completeAnOrder(order,bookService.getBookRepository());
    }

    @Override
    public Order[] sortOrdersByExecutionDate(Order[] ordersArray) {
        return orderService.sortOrders(new ExecutionDateComparator(),ordersArray);
    }

    @Override
    public Order[] sortOrdersByPrice(Order[] ordersArray) {
        return orderService.sortOrders(new OrderPriceComparator(),ordersArray);
    }

    @Override
    public Order[] sortOrdersByStatus(Order[] ordersArray) {
        return orderService.sortOrders(new OrderStatusComparator(),ordersArray);
    }

    @Override
    public Request[] getAllRequests() {
        return requestService.getAllRequests();
    }

    @Override
    public void addRequest(Request request) {
        requestService.addRequest(request);
    }

    @Override
    public Request[] sortRequestByAlphabet(Request[] requestsArray) {
        return requestService.sortRequests(new RequestAlphabetComparator(),requestsArray);
    }

    @Override
    public Request[] sortByAmountOfRequests(Request[] requestsArray) {
        return requestService.sortRequests(new RequestAmountComparator(),requestsArray);
    }

    public BookService getBookService() {
        return bookService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public RequestService getRequestService() {
        return requestService;
    }
}
