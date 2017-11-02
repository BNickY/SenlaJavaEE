package com.senla.bookshop.runner;
import com.senla.bookshop.facade.BookShop;
import com.senla.bookshop.utils.Printer;

public class Test {
    public static void main(String[] args) {
        BookShop bookShop = new BookShop();
        bookShop.readBooksFromFile();
        bookShop.getAllBooks();

        Printer.printMessage("");
        bookShop.sortBooksByPrice();

        Printer.printMessage("");
        bookShop.readOrdersFromFile();
        bookShop.showAllOrders();
        Printer.printMessage("");
        bookShop.completeAnOrder(bookShop.getOrder(0));
        bookShop.showAllOrders();

        bookShop.readRequestsFromFile();
        Printer.printMessage("");
        bookShop.showAllRequests();
    }
}
