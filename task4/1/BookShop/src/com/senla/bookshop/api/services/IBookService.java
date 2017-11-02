package com.senla.bookshop.api.services;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;

import java.util.Comparator;

public interface IBookService {

    Book[] getAllBooks();
    Book[] getUnsoldBooks();
    void addBook(Book book, Request[] requests);
    void deleteBook(long id);
    Book getBook(long id);
    void saveToFile();
    void readFromFile();
    Book[] sortAllBooks(Comparator<Book> comparator);
    Book[] sortUnsoldBooks(Comparator<Book> comparator);
}
