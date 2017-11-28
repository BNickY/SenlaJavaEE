package com.senla.bookshop.api.repositories;

import com.senla.bookshop.api.entities.IBook;

import java.io.IOException;
import java.util.List;

public interface IBookRepository {

    List<IBook> getBooks();

    void addBook(IBook book);

    void deleteBook(long id);

    IBook getBook(long id);

    void setBooks(List<IBook> books);

    void exportBooks(String file) throws IOException;

    void importBooks(String file) throws IOException;
}
