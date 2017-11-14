package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IBook;
import java.util.List;

public interface IBookRepository {

    List<IBook> getAllBooks();

    void addBook(IBook book);

    void deleteBook(long id);

    IBook getBook(long id);

    void saveToFile();

    void readFromFile();
}
