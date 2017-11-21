package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.repositories.IBookRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private static BookRepository bookRepository;
    private List<IBook> books = new ArrayList<>();
    private TextFileUtil fileUtil = new TextFileUtil("books.txt");
    private static long nextId = 0;

    private BookRepository(){}

    public static synchronized BookRepository getInstance(){
        if(bookRepository == null)
            bookRepository = new BookRepository();

        return bookRepository;
    }

    public List<IBook> getBooks(){
        return books;
    }

    public void addBook(IBook book){
        book.setId(nextId);
        nextId++;
        books.add(book);
    }

    public void deleteBook(long id){
        books.remove(getBook(id));
    }

    public IBook getBook(long id){
        for(IBook book : books)
            if(book.getId() == id) return book;
        return null;
    }

    public void saveToFile() {
        fileUtil.writeDataToFile(Converter.entitiesToStrings(books));
    }

    public void readFromFile() {
        books = Converter.stringsToBooks(fileUtil.readDataFromFile());
        if(books.size() > 0)
            nextId = books.get(books.size()-1).getId() + 1;
    }
}
