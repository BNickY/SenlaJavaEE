package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class DeleteBook implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        if(facade.getAllBooks().size() > 0) {
            Printer.printArray(facade.getAllBooks());
            Printer.printMessage("\nEnter book id to delete: ");
            if (facade.deleteBook(ConsoleReader.getNextLong())) {
                Printer.printMessage("Book was deleted");
            } else
                Printer.printMessage("There is no book with such id!");
        }else
            Printer.printMessage("There are no books to delete");
    }
}
