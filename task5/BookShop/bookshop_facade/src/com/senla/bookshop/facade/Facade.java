package com.senla.bookshop.facade;

import com.senla.bookshop.api.comparators.book.*;
import com.senla.bookshop.api.comparators.order.ExecutionDateComparator;
import com.senla.bookshop.api.comparators.order.OrderPriceComparator;
import com.senla.bookshop.api.comparators.order.StatusComparator;
import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.api.services.IBookService;
import com.senla.bookshop.api.services.IOrderService;
import com.senla.bookshop.api.services.IRequestService;
import com.senla.bookshop.services.BookService;
import com.senla.bookshop.services.OrderService;
import com.senla.bookshop.services.RequestService;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class Facade implements IFacade {
    private static Logger log = Logger.getLogger(Facade.class.getName());
    private static Facade facade;
    private IBookService bookService = new BookService();
    private IOrderService orderService = new OrderService();
    private IRequestService requestService = new RequestService();

    private Facade() {}

    public static synchronized Facade getInstance(){
        if(facade == null)
            facade = new Facade();

        return facade;
    }

    @Override
    public void addBook(IBook book) {
        bookService.addBook(book);
    }

    @Override
    public void deleteBook(long id) {
        bookService.deleteBook(id);
    }

    @Override
    public IBook getBook(long id) {
        return bookService.getBook(id);
    }

    @Override
    public List<IBook> getAllBooks() {
        return bookService.getAllBooks();
    }

    @Override
    public List<IBook> getUnsoldBooks() {
        return bookService.getUnsoldBooks();
    }

    @Override
    public List<IBook> sortBooksByPrice() {
        return bookService.sortBooks(new BookPriceComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByTitle() {
        return bookService.sortBooks(new TitleComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByPublishDate() {
        return bookService.sortBooks(new PublishDateComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByExistenceInStoke() {
        return bookService.sortBooks(new InStokeComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortUnsoldBooksByPrice() {
        return bookService.sortBooks(new BookPriceComparator(),getUnsoldBooks());
    }

    @Override
    public List<IBook> sortUnsoldBooksByReceiptDate() {
        return bookService.sortBooks(new ReceiptDateComparator(),getUnsoldBooks());
    }

    @Override
    public void addOrder(IOrder order) {
        orderService.addOrder(order,bookService.getBook(order.getBookId()).getPrice());
    }

    @Override
    public void cancelOrder(long id) {
        orderService.cancelOrder(id);
    }

    @Override
    public IOrder getOrder(long id) {
        return orderService.getOrder(id);
    }

    @Override
    public List<IOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @Override
    public List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate) {
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
    public void completeAnOrder(long id) {
        orderService.completeAnOrder(id);
    }

    @Override
    public List<IOrder> sortOrdersByPrice() {
        return orderService.sortOrders(new OrderPriceComparator(),getAllOrders());
    }

    @Override
    public List<IOrder> sortOrdersByStatus() {
        return orderService.sortOrders(new StatusComparator(), getAllOrders());
    }

    @Override
    public List<IOrder> sortOrdersByExecutionDate() {
        return orderService.sortOrders(new ExecutionDateComparator(),getAllOrders());
    }

    @Override
    public List<IOrder> sortPerformedOrdersByDate() {
        return orderService.sortOrders(new ExecutionDateComparator(), orderService.getPerformedOrders());
    }

    @Override
    public List<IOrder> sortPerformedOrdersByPrice() {
        return orderService.sortOrders(new OrderPriceComparator(), orderService.getPerformedOrders());
    }

    @Override
    public List<IRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @Override
    public void addRequest(IRequest request) {
        requestService.addRequest(request);
    }

    @Override
    public List<IRequest> sortRequestsByAlphabet() {
        return requestService.sortRequestsByAlphabet();
    }

    @Override
    public List<IRequest> sortRequestsByAmount() {
        return requestService.sortRequestsByAmount();
    }

    @Override
    public void load() {
        bookService.readFromFile();
        orderService.readFromFile();
        requestService.readFromFile();
    }

    @Override
    public void exit(){
        bookService.saveToFile();
        orderService.saveToFile();
        requestService.saveToFile();
    }
}
