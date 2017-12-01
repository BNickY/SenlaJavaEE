package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.api.entities.IBook;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class GetBook implements IAction {

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllBooks());
        Printer.printMessage("\nEnter book id to get description: ");
        IBook book = facade.getBook(ConsoleReader.getNextLong());
        if(book != null)
            Printer.printEntity(book);
        else
            Printer.printMessage("There is no book with such id!");
    }
}
