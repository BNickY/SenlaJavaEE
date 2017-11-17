package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.entities.Order;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class AddOrder implements IAction {

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllBooks());
        Printer.printMessage("\nChoose book (enter book id): ");
        facade.addOrder(new Order(ConsoleReader.getNextLong()));
    }
}
