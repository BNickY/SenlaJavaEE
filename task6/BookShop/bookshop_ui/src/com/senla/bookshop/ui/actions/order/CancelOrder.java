package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class CancelOrder implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllOrders());
        Printer.printMessage("\nChoose order (enter order id): ");
        if(Facade.getInstance().cancelOrder(ConsoleReader.getNextLong())){
            Printer.printMessage("Order was canceled");
        }else
            Printer.printMessage("Can't complete action: no order with such id/ order is canceled or performed.");
    }
}
