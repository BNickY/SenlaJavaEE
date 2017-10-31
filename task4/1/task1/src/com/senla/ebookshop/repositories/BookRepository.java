package com.senla.ebookshop.repositories;

import com.senla.ebookshop.comparators.book.*;
import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.model.requeststatus.RequestStatus;
import com.senla.ebookshop.utils.ArrayWorker;
import com.senla.ebookshop.utils.DateUtil;
import com.senla.ebookshop.utils.Printer;
import java.util.Arrays;

public class BookRepository {
    private static final int MONTHS_TO_SEll = 6;
    private Book[] books = new Book[ArrayWorker.getStartSize()];
    private static int id = 0;

    public Book[] getAllBooks() {
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

        int position = ArrayWorker.getNextFreePosition(books);
        book.setId(id);
        book.setInStoke(true);
        id++;
        books[position] = book;
    }

    public void deleteBook(int id){
        for (int i = 0; i < books.length; i++)
             if(books[i] != null && books[i].getId() == id)
                books[i].setInStoke(false);
    }

    public Book getBook(int id){
        return (Book) ArrayWorker.findById(books,id);
    }

    public void refreshBookArray(){
        books = (Book[]) ArrayWorker.compressArray(books);
    }

    public Book[] getUnsoldBooks(){
        Book[] unsoldBooks = new Book[books.length];
        for(int i = 0; i < books.length; i++){
            if(books[i] == null)
                unsoldBooks[i] = null;
            else if(DateUtil.getMonthsDifference(books[i].getReceiptDate()) > MONTHS_TO_SEll)
                unsoldBooks[i] = books[i];
            else unsoldBooks[i] = null;
        }
        unsoldBooks = (Book[]) ArrayWorker.compressArray(unsoldBooks);
        return unsoldBooks;
    }

    public Book[] sortBooksByTitle(Book[] booksArray){
        Arrays.sort(booksArray, new TitleComparator());
        Printer.printMessage("Sorted by title");
        return booksArray;
    }

    public Book[] sortBooksByPrice(Book[] booksArray){
        Arrays.sort(booksArray, new BookPriceComparator());
        Printer.printMessage("Sorted by price");
        return booksArray;
    }

    public Book[] sortBooksByPublishDate(Book[] booksArray) {
        Arrays.sort(booksArray, new PublishDateComparator());
        Printer.printMessage("Sorted by publish date");
        return booksArray;
    }

    public Book[] sortBooksByReceiptDate(Book[] booksArray) {
        Arrays.sort(booksArray, new ReceiptDateComparator());
        Printer.printMessage("Sorted by receipt date");
        return booksArray;
    }

    public Book[] sortBooksByExistenceInStoke(Book[] booksArray) {
        Arrays.sort(booksArray, new InStokeComparator());
        Printer.printMessage("Sorted by existence in stoke");
        return booksArray;
    }
}
