package com.senla.ebookshop.interfaces;

import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.model.Request;

import java.util.Comparator;

public interface IBookService {

    Book[] getAllBooks();

    void addBook(Book book, Request[] requests);

    void deleteBook(int id);

    Book getBook(int id);

    void refreshBookArray();

    Book[] getUnsoldBooks();

    Book[] sortBooks(Comparator comparator, Book[] booksArray);
}
