package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class CancelOrder implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllRequests());
        Printer.printMessage("\nChoose order (enter order id): ");
        Facade.getInstance().cancelOrder(ConsoleReader.getNextLong());
    }
}
