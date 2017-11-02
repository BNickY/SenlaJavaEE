package com.senla.bookshop.repositories;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.entities.requeststatus.RequestStatus;
import com.senla.bookshop.utils.ArrayWorker;
import com.senla.bookshop.utils.TextParser;
import com.senla.bookshop.utils.TextFileUtil;
import java.util.Arrays;

public class BookRepository {
    private static final String filePath = "data_files/books.txt";
    private TextFileUtil textFileUtil = new TextFileUtil(filePath);
    private Book[] books;
    private static long nextId = 0;

    public BookRepository() {
        books = new Book[ArrayWorker.START_SIZE];
        TextParser.booksArray = books;
    }

    public Book[] getAllBooks(){
        return books;
    }

    public void addBook(Book book, Request[] requests){
        if(requests != null){
            for(int i = 0; i < requests.length; i++)
                if(requests[i] != null && requests[i].getBook().getTitle().equals(book.getTitle())){
                    requests[i].setRequestStatus(RequestStatus.PERFORMED);
                }
        }

        for(int i = 0; i < books.length; i++){
            if(books[i] != null && books[i].getTitle().equals(book.getTitle())){
                books[i].setInStoke(true);
                return;
            }
        }

        if(!ArrayWorker.hasEmptySpace(books))
            books = (Book[]) ArrayWorker.expandArray(books);
        book.setId(nextId);
        nextId++;
        book.setInStoke(true);
        int position = ArrayWorker.getNextFreePosition(books);
        books[position] = book;

    }

    public void deleteBook(long id){
        int i, j;
        for(i = j = 0; j < books.length; j++)
            if(books[j] != null && (books[j].getId() != id)) books[i++] = books[j];
        books = Arrays.copyOf(books,i);
    }

    public Book getBook(long id){
        return (Book) ArrayWorker.findById(books,id);
    }

    public void saveToFile(){
        books = (Book[]) ArrayWorker.compressArray(books);
        textFileUtil.writeDataToFile(TextParser.parseEntities(books));
    }

    public void readFromFile(){
        books = TextParser.parseBookStrings(textFileUtil.readDataFromFile());
        TextParser.booksArray = books;
        nextId = books[books.length-1].getId() + 1;
    }
}
