package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.entities.Book;
import com.senla.bookshop.facade.Facade;
import java.time.LocalDate;
import static com.senla.bookshop.utils.ConsoleReader.*;
import static com.senla.bookshop.utils.Printer.*;

public class AddBook implements IAction{

    @Override
    public void execute() {

        printMessage("Enter book title: ");
        String title = getNextLine();

        printMessage("Enter book author: ");
        String author = getNextLine();

        printMessage("Enter book price: ");
        double price = getNextDouble();

        printMessage("Enter book publish date (yyyy-MM-dd): ");
        LocalDate publishDate = getDate();

        Facade.getInstance().addBook(new Book(title,author,price,publishDate));
    }
}
