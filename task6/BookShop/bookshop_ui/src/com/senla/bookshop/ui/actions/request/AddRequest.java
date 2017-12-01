package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.entities.Request;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class AddRequest implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllBooks());
        Printer.printMessage("\nChoose book (enter book id): ");
        if(facade.addRequest(new Request(ConsoleReader.getNextLong()))){
            Printer.printMessage("Request added");
        }else
            Printer.printMessage("Request is not added.");
    }
}
