package com.senla.bookshop.facade;

import com.senla.bookshop.api.comparators.book.*;
import com.senla.bookshop.api.comparators.order.*;
import com.senla.bookshop.api.entities.*;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.exeptions.DataNotExistException;
import com.senla.bookshop.api.facade.IFacade;
import com.senla.bookshop.api.services.*;
import com.senla.bookshop.services.*;
import java.time.LocalDate;
import java.util.List;

public class Facade implements IFacade {
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
    public void deleteBook(long id) throws DataNotExistException{
        if(getBook(id) != null)
            bookService.deleteBook(id);

    }

    @Override
    public IBook getBook(long id) throws DataNotExistException {
        IBook book = bookService.getBook(id);
        if(book != null)
            return book;
        else
            throw new DataNotExistException("There is no book with such id!");
    }

    @Override
    public List<IBook> getAllBooks() throws DataNotExistException{
        if(bookService.getAllBooks().size() > 0)
            return bookService.getAllBooks();
        else
            throw new DataNotExistException("There are no books in stock.");
    }

    @Override
    public List<IBook> getUnsoldBooks() throws DataNotExistException {
        if(bookService.getUnsoldBooks().size() > 0)
            return bookService.getUnsoldBooks();
        else
            throw new DataNotExistException("There are no unsold books in stock.");
    }

    @Override
    public List<IBook> sortBooksByPrice() throws DataNotExistException {
        return bookService.sortBooks(new BookPriceComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByTitle() throws DataNotExistException {
        return bookService.sortBooks(new TitleComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByPublishDate() throws DataNotExistException {
        return bookService.sortBooks(new PublishDateComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortBooksByExistenceInStoke() throws DataNotExistException {
        return bookService.sortBooks(new InStokeComparator(),getAllBooks());
    }

    @Override
    public List<IBook> sortUnsoldBooksByPrice() throws DataNotExistException {
        return bookService.sortBooks(new BookPriceComparator(),getUnsoldBooks());
    }

    @Override
    public List<IBook> sortUnsoldBooksByReceiptDate() throws DataNotExistException {
        return bookService.sortBooks(new ReceiptDateComparator(),getUnsoldBooks());
    }

    @Override
    public void addOrder(IOrder order) throws DataNotExistException {
        IBook book = getBook(order.getBookId());
        if( book.getInStoke())
            orderService.addOrder(order,book.getPrice());
        else
            throw new DataNotExistException("This book is already sold. But you can make request.");
    }

    @Override
    public void cancelOrder(long id) throws DataNotExistException {
        IOrder order = getOrder(id);
        if(order.getOrderStatus() != OrderStatus.ACCEPTED)
            throw new DataNotExistException("This order is canceled or already performed.");
        else
            orderService.cancelOrder(id);
    }

    @Override
    public IOrder getOrder(long id) throws DataNotExistException {
        IOrder order = orderService.getOrder(id);
        if (order != null)
            return order;
        else
            throw new DataNotExistException("There is no order with such id!");
    }

    @Override
    public List<IOrder> getAllOrders() throws DataNotExistException {
        if(orderService.getAllOrders().size() > 0)
            return orderService.getAllOrders();
        else
            throw new DataNotExistException("There are no orders.");
    }

    @Override
    public List<IOrder> getPerformedOrders(LocalDate startDate, LocalDate endDate) throws DataNotExistException {
        if(orderService.getPerformedOrders(startDate,endDate).size() > 0)
            return orderService.getPerformedOrders(startDate,endDate);
        else
            throw new DataNotExistException("There are no performed orders.");
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
    public void completeAnOrder(long id) throws DataNotExistException {
        IOrder order = getOrder(id);
        if(order.getOrderStatus() == OrderStatus.ACCEPTED)
            orderService.completeAnOrder(id);
        else
            throw new DataNotExistException("This order is canceled or already performed.");
    }

    @Override
    public List<IOrder> sortOrdersByPrice() throws DataNotExistException {
        return orderService.sortOrders(new OrderPriceComparator(),getAllOrders());
    }

    @Override
    public List<IOrder> sortOrdersByStatus() throws DataNotExistException {
        return orderService.sortOrders(new StatusComparator(), getAllOrders());
    }

    @Override
    public List<IOrder> sortOrdersByExecutionDate() throws DataNotExistException {
        return orderService.sortOrders(new ExecutionDateComparator(),getAllOrders());
    }

    @Override
    public List<IOrder> sortPerformedOrdersByDate() throws DataNotExistException {
        if(orderService.getPerformedOrders().size() > 0)
            return orderService.sortOrders(new ExecutionDateComparator(), orderService.getPerformedOrders());
        else
            throw new DataNotExistException("There are no performed orders.");
    }

    @Override
    public List<IOrder> sortPerformedOrdersByPrice() throws DataNotExistException{
        if(orderService.getPerformedOrders().size() > 0)
            return orderService.sortOrders(new OrderPriceComparator(), orderService.getPerformedOrders());
        else
            throw new DataNotExistException("There are no performed orders.");
    }

    @Override
    public List<IRequest> getAllRequests() throws DataNotExistException {
        if(requestService.getAllRequests().size() > 0)
            return requestService.getAllRequests();
        else
            throw new DataNotExistException("There are no requests.");
    }

    @Override
    public void addRequest(IRequest request) throws DataNotExistException {
        IBook book = getBook(request.getBookId());
        if(!book.getInStoke())
            requestService.addRequest(request);
        else
            throw new DataNotExistException("This book is in stock. You can buy it.");
    }

    @Override
    public List<IRequest> sortRequestsByAlphabet() throws DataNotExistException {
        if(requestService.getAllRequests().size() > 0)
            return requestService.sortRequestsByAlphabet();
        else
            throw new DataNotExistException("There are no requests.");
    }

    @Override
    public List<IRequest> sortRequestsByAmount() throws DataNotExistException {
        if(requestService.getAllRequests().size() > 0)
            return requestService.sortRequestsByAmount();
        else
            throw new DataNotExistException("There are no requests.");
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
