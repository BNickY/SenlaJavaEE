package com.senla.ebookshop.services;

import com.senla.ebookshop.comparators.book.*;
import com.senla.ebookshop.interfaces.IBookService;
import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.repositories.BookRepository;
import java.util.Comparator;

public class BookService implements IBookService{

    private BookRepository bookRepository = new BookRepository();

    @Override
    public Book[] getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public void addBook(Book book, Request[] requests) {
        bookRepository.addBook(book, requests);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getBook(id);
    }

    @Override
    public void refreshBookArray() {
        bookRepository.refreshBookArray();
    }

    @Override
    public Book[] getUnsoldBooks() {
        return bookRepository.getUnsoldBooks();
    }

    @Override
    public Book[] sortBooks(Comparator comparator, Book[] booksArray) {
        if(TitleComparator.class == comparator.getClass()){
            return bookRepository.sortBooksByTitle(booksArray);
        }
        else if(BookPriceComparator.class == comparator.getClass()){
            return bookRepository.sortBooksByPrice(booksArray);
        }
        else if(PublishDateComparator.class == comparator.getClass()){
            return bookRepository.sortBooksByPublishDate(booksArray);
        }
        else if(ReceiptDateComparator.class == comparator.getClass()){
            return bookRepository.sortBooksByReceiptDate(booksArray);
        }
        else if(InStokeComparator.class == comparator.getClass()){
            return bookRepository.sortBooksByExistenceInStoke(booksArray);
        }
        else return null;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}