package com.senla.bookshop.api.services;

import com.senla.bookshop.api.entities.IBook;
import java.util.Comparator;
import java.util.List;

public interface IBookService {

    List<IBook> getAllBooks();

    List<IBook> getUnsoldBooks();

    void addBook(IBook book);

    void deleteBook(long id);

    IBook getBook(long id);

    List<IBook> sortBooks(Comparator<IBook> comparator, List<IBook> bookList);

    void saveToFile();

    void readFromFile();
}
