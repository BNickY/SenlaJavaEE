package com.senla.bookshop.runner;
import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.utils.Printer;

public class Test {
    public static void main(String[] args) {
         BookShop bookShop = new BookShop();

        Book book1 = new Book("War and Peace","Tolstoy",12.2,
                LocalDate.of(1863,3,4),LocalDate.of(2015,7,4));
        Book book2 = new Book("Idiot","Dostoevsky",9.80,
                LocalDate.of(1868,2,3),LocalDate.of(2015,3,20));
        Book book3 = new Book("Demons","Dostoevsky",5.5,
                LocalDate.of(1872,3,2),LocalDate.of(2016,10,11));

        bookShop.addBook(book1);
        bookShop.addBook(book2);
        bookShop.addBook(book3);
        bookShop.showAllBooks();
        Printer.printMessage("");
        bookShop.sortBooksByPrice();

        Order order1 = new Order((bookShop.getBook(1)),
                LocalDate.of(2015,1,1),LocalDate.of(2015,1,5));
        bookShop.addOrder(order1);
        bookShop.completeAnOrder(order1);
        Printer.printMessage("");
        bookShop.showAllOrders();
        Printer.printMessage("");
        bookShop.showAllBooks();

        Request request = new Request(bookShop.getBook(1),LocalDate.of(2015,2,3));
        bookShop.addRequest(request);
        Printer.printMessage("");
        Printer.printObject(request);
    }
}
