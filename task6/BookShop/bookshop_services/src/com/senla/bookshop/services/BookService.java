package com.senla.bookshop.services;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.entities.IOrder;
import com.senla.bookshop.api.entities.IRequest;
import com.senla.bookshop.api.entities.orderstatus.OrderStatus;
import com.senla.bookshop.api.entities.requeststatus.RequestStatus;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.api.repositories.IBookRepository;
import com.senla.bookshop.api.services.IBookService;
import com.senla.bookshop.repositories.BookRepository;
import com.senla.bookshop.repositories.OrderRepository;
import com.senla.bookshop.repositories.RequestRepository;
import com.senla.bookshop.utils.DateUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookService implements IBookService {
    private IBookRepository bookRepository;
    private int monthsToSell;
    private boolean isRequestMarked;

    public BookService(int monthsToSell, boolean isRequestMarked){
        this.monthsToSell = monthsToSell;
        this.isRequestMarked = isRequestMarked;
        bookRepository = BookRepository.getInstance();
    }

    @Override
    public List<IBook> getAllBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public List<IBook> getUnsoldBooks() {
        List<IBook> books = getAllBooks();
        List<IBook> unsoldBooks = new ArrayList<>();
        for (IBook book : books) {
            if (book != null &&
                    (DateUtil.getMonthsDifference(book.getReceiptDate()) > monthsToSell & book.getInStoke()))
                unsoldBooks.add(book);
        }
        return unsoldBooks;
    }

    @Override
    public void addBook(IBook book) {
        List<IRequest> requests = RequestRepository.getInstance().getRequests();
        List<IBook> books = new ArrayList<>(getAllBooks());
        if (books.contains(book)) {
            IBook oldBook = books.get(books.indexOf(book));
            oldBook.setInStoke(true);
            oldBook.setReceiptDate(LocalDate.now());
            if(isRequestMarked) {
                for (IRequest request : requests)
                    if (request.getBookId() == book.getId())
                        request.setRequestStatus(RequestStatus.PERFORMED);
            }
            return;
        }

        book.setReceiptDate(LocalDate.now());
        book.setInStoke(true);
        bookRepository.addBook(book);
    }

    @Override
    public boolean deleteBook(long id) {
        if(bookRepository.deleteBook(id)) {
            List<IOrder> orders = OrderRepository.getInstance().getOrders();
            List<IRequest> requests = RequestRepository.getInstance().getRequests();
            for (IRequest request : requests)
                if (request.getBookId() == id && request.getRequestStatus().compareTo(RequestStatus.ACCEPTED)==0)
                    request.setRequestStatus(RequestStatus.CANCELED);
            for (IOrder order : orders)
                if (order.getBookId() == id && order.getOrderStatus().compareTo(OrderStatus.ACCEPTED)==0) {
                    order.setExecutionDate(LocalDate.now());
                    order.setOrderStatus(OrderStatus.CANCELED);
                }
            return true;
        }else
            return false;
    }

    @Override
    public IBook getBook(long id) {
        return bookRepository.getBook(id);
    }


    @Override
    public List<IBook> sortBooks(Comparator<IBook> comparator, List<IBook> bookList) {
        List<IBook> books = new ArrayList<>(bookList);
        books.sort(comparator);
        return books;
    }

    @Override
    public void setBooks(List<IBook> books) {
        bookRepository.setBooks(books);
    }

    @Override
    public void exportBooks(String file) throws IOException {
        bookRepository.exportBooks(file);
    }

    @Override
    public void importBooks(String file) throws IOException, FormatException {
        bookRepository.importBooks(file);
    }
}
