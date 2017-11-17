package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class GetOrder implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllOrders());
        Printer.printMessage("\nEnter order id to get description: ");
        Printer.printEntity(facade.getOrder(ConsoleReader.getNextLong()));
    }
}
