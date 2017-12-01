package com.senla.bookshop.facade;

import com.senla.bookshop.api.comparators.book.*;
import com.senla.bookshop.api.comparators.order.*;
import com.senla.bookshop.api.entities.*;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.api.services.*;
import com.senla.bookshop.config.PropertyStorage;
import com.senla.bookshop.services.*;
import com.senla.bookshop.utils.SerializationUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Facade implements IFacade {
    private static final Logger LOGGER = LogManager.getLogger(Facade.class);
    private static Facade facade;
    private PropertyStorage properties = PropertyStorage.getInstance();
    private IBookService bookService = new BookService(properties.getMonthsToSale(), properties.isRequestMarked());
    private IOrderService orderService = new OrderService();
    private IRequestService requestService = new RequestService();

    private Facade() {}

    public static Facade getInstance(){
        if(facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    @Override
    public void addBook(IBook book) {
        bookService.addBook(book);
    }

    @Override
    public boolean deleteBook(long id){
       return bookService.deleteBook(id);
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
    public boolean exportBooks(String file) {
        try {
            bookService.exportBooks(file);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean importBooks(String file) {
        try {
            bookService.importBooks(file);
            return true;
        } catch (IOException | FormatException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addOrder(IOrder order) {
        return orderService.addOrder(order);
    }

    @Override
    public boolean cancelOrder(long id){
        return orderService.cancelOrder(id);
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
    public List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate)  {
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
    public boolean completeAnOrder(long id) {
        return orderService.completeAnOrder(id);
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
    public boolean exportOrders(String file){
        try {
            orderService.exportOrders(file);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean importOrders(String file){
        try {
            orderService.importOrders(file);
            return true;
        } catch (IOException | FormatException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<IRequest> getAllRequests(){
        return requestService.getAllRequests();
    }

    @Override
    public boolean addRequest(IRequest request)  {
        return requestService.addRequest(request);
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
    public boolean exportRequests(String file) {
        try {
            requestService.exportRequests(file);
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean importRequests(String file) {
        try {
            requestService.importRequests(file);
            return true;
        } catch (IOException | FormatException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean load() {
        List<Object> entityList;
        try {
            entityList = SerializationUtil.loadData(PropertyStorage.getInstance().getDataFilePath());
        } catch (ClassNotFoundException | IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
        if(entityList == null) return false;
        bookService.setBooks((List<IBook>) entityList.get(0));
        orderService.setOrders((List<IOrder>) entityList.get(1));
        requestService.setRequests((List<IRequest>) entityList.get(2));
        return true;
    }

    @Override
    public boolean exit(){
        List<Object> entityList = new ArrayList<>();
        entityList.add(bookService.getAllBooks());
        entityList.add(orderService.getAllOrders());
        entityList.add(requestService.getAllRequests());
        try {
            SerializationUtil.saveData(entityList,PropertyStorage.getInstance().getDataFilePath());
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            return false;
        }
    }
}
