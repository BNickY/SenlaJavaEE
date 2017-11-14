package com.senla.bookshop.facade;

import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.comparators.book.*;
import com.senla.bookshop.comparators.book.BookPriceComparator;
import com.senla.bookshop.comparators.order.ExecutionDateComparator;
import com.senla.bookshop.comparators.order.OrderPriceComparator;
import com.senla.bookshop.comparators.order.StatusComparator;
import com.senla.bookshop.comparators.request.RequestAlphabetComparator;
import com.senla.bookshop.comparators.request.RequestAmountComparator;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.services.BookService;
import com.senla.bookshop.services.OrderService;
import com.senla.bookshop.services.RequestService;
import com.senla.bookshop.utils.Printer;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.time.LocalDate;

public class BookShop implements IFacade{
    private BookService bookService;
    private OrderService orderService;
    private RequestService requestService;

    public BookShop() {
        bookService = new BookService();
        orderService = new OrderService();
        requestService = new RequestService();
    }

    @Override
    public void addBook(Book book) {
        bookService.addBook(book, requestService.getAllRequests());
    }

    @Override
    public void deleteBook(long id) {
        bookService.deleteBook(id);
    }

    @Override
    public Book getBook(long id) {
        return bookService.getBook(id);
    }

    @Override
    public void getAllBooks() {
        Printer.printArray(bookService.getAllBooks());
    }

    @Override
    public void showUnsoldBooks() {
        Printer.printArray(bookService.getUnsoldBooks());
    }

    @Override
    public void sortBooksByPrice() {
        Printer.printArray(bookService.sortAllBooks(new BookPriceComparator()));
    }

    @Override
    public void sortBooksByTitle() {
        Printer.printArray(bookService.sortAllBooks(new TitleComparator()));
    }

    @Override
    public void sortBooksByPublishDate() {
        Printer.printArray(bookService.sortAllBooks(new PublishDateComparator()));
    }

    @Override
    public void sortBooksByExistenceInStoke() {
        Printer.printArray(bookService.sortAllBooks(new InStokeComparator()));
    }

    @Override
    public void sortUnsoldBooksByPrice() {
        Printer.printArray(bookService.sortUnsoldBooks(new BookPriceComparator()));
    }

    @Override
    public void sortUnsoldBooksByReceiptDate() {
        Printer.printArray(bookService.sortUnsoldBooks(new ReceiptDateComparator()));
    }

    public void saveBooksToFile(){
        bookService.saveToFile();
    }
    public void readBooksFromFile(){
        bookService.readFromFile();
    }

    public void saveOrdersToFile(){
        orderService.saveToFile();
    }
    public void readOrdersFromFile(){
        orderService.readFromFile();
    }

    public void saveRequestsToFile(){
        requestService.saveToFile();
    }
    public void readRequestsFromFile(){
        requestService.readFromFile();
    }

    @Override
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    @Override
    public void deleteOrder(long id) {
        orderService.deleteOrder(id);
    }

    @Override
    public Order getOrder(long id) {
        return (orderService.getOrder(id));
    }

    @Override
    public void showAllOrders() {
        Printer.printArray(orderService.getAllOrders());
    }

    @Override
    public void showPerformedOrders(LocalDate startDate, LocalDate endDate) {
        Printer.printArray(orderService.getPerformedOrders(startDate,endDate));
    }

    @Override
    public void showEarnedMoney(LocalDate startDate, LocalDate endDate) {
        Printer.printMessage(String.valueOf(orderService.getEarnedMoney(startDate,endDate)));
    }

    @Override
    public void showAmountOfPerformedOrders(LocalDate startDate, LocalDate endDate) {
        Printer.printMessage(String.valueOf(orderService.getAmountOfPerformedOrders(startDate,endDate)));
    }

    @Override
    public void completeAnOrder(Order order) {
        orderService.completeAnOrder(order,bookService);
    }

    @Override
    public void sortOrdersByPrice() {
        Printer.printArray(orderService.sortAllOrders(new OrderPriceComparator()));
    }

    @Override
    public void sortOrdersByStatus() {
        Printer.printArray(orderService.sortAllOrders(new StatusComparator()));
    }

    @Override
    public void sortOrdersByExecutionDate() {
        Printer.printArray(orderService.sortAllOrders(new ExecutionDateComparator()));
    }

    @Override
    public void sortPerformedOrdersByDate() {
        Printer.printArray(orderService.sortPerformedOrders(new ExecutionDateComparator()));
    }

    @Override
    public void sortPerformedOrdersByPrice() {
        Printer.printArray(orderService.sortPerformedOrders(new OrderPriceComparator()));
    }

    @Override
    public void showAllRequests() {
        Printer.printArray(requestService.getAllRequests());
    }

    @Override
    public void addRequest(Request request) {
        requestService.addRequest(request);
    }

    @Override
    public void sortRequestsByAlphabet() {
        Printer.printArray(requestService.sortRequests(new RequestAlphabetComparator()));
    }

    @Override
    public void sortRequestsByAmount() {
        Printer.printArray(requestService.sortRequests(new RequestAmountComparator()));
    }
}
