package com.senla.bookshop.services;

import com.senla.bookshop.api.services.IBookService;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.repositories.BookRepository;
import com.senla.bookshop.utils.DateUtil;

import java.util.Arrays;
import java.util.Comparator;

public class BookService implements IBookService{
    private BookRepository bookRepository;
    private static final int MONTHS_TO_SEll = 6;

    public BookService() {
        bookRepository = new BookRepository();
    }

    @Override
    public Book[] getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book[] getUnsoldBooks() {
        Book[] books = getAllBooks();
        Book[] unsoldBooks = new Book[books.length];
        for(int i = 0; i < unsoldBooks.length; i++){
            if(books[i] != null &&
                    (DateUtil.getMonthsDifference(books[i].getReceiptDate()) > MONTHS_TO_SEll & books[i].getInStoke()))
                unsoldBooks[i] = books[i];
            else unsoldBooks[i] = null;
        }
        return unsoldBooks;
    }

    @Override
    public void addBook(Book book, Request[] requests) {
        bookRepository.addBook(book, requests);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public Book getBook(long id) {
        return bookRepository.getBook(id);
    }

    @Override
    public void saveToFile() {
        bookRepository.saveToFile();
    }

    @Override
    public void readFromFile() {
        bookRepository.readFromFile();
    }

    @Override
    public Book[] sortUnsoldBooks(Comparator<Book> comparator) {
        Book[] booksArray = getUnsoldBooks();
        Arrays.sort(booksArray, comparator);
        return booksArray;
    }

    @Override
    public Book[] sortAllBooks(Comparator<Book> comparator) {
        Book[] booksArray = Arrays.copyOf(getAllBooks(),getAllBooks().length);
        Arrays.sort(booksArray, comparator);
        return booksArray;
    }
}
