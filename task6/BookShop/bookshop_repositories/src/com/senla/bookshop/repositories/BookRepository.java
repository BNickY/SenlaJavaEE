package com.senla.bookshop.repositories;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.api.exeptions.FormatException;
import com.senla.bookshop.api.repositories.IBookRepository;
import com.senla.bookshop.utils.Converter;
import com.senla.bookshop.utils.TextFileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private static BookRepository bookRepository;
    private List<IBook> books = new ArrayList<>();
    private static long nextId = 0;

    private BookRepository(){}

    public static BookRepository getInstance(){
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

    public boolean deleteBook(long id){
        IBook book = getBook(id);
        if(book != null){
            book.setInStoke(false);
            return true;
        }
        return false;
    }

    public IBook getBook(long id){
        for(IBook book : books)
            if(book.getId() == id) return book;
        return null;
    }

    @Override
    public void setBooks(List<IBook> books) {
        this.books = books;
        if(this.books.size() > 0)
            nextId = this.books.get(this.books.size()-1).getId() + 1;
    }

    @Override
    public void exportBooks(String file) throws IOException {
        TextFileUtil.writeDataToFile(Converter.entitiesToStrings(books),file);
    }

    @Override
    public void importBooks(String file) throws IOException, FormatException {
       List<IBook> booksToAdd = Converter.stringsToBooks(TextFileUtil.readDataFromFile(file));
        for (IBook book : booksToAdd) {
            IBook addedBook = getBook(book.getId());
            if (addedBook != null) {
                books.set(books.indexOf(addedBook),book);
            } else {
                addBook(book);
            }
        }
    }
}
