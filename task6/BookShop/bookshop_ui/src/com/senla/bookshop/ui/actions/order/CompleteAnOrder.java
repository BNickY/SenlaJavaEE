package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class CompleteAnOrder implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllOrders());
        Printer.printMessage("\nChoose order (enter order id): ");
        if(Facade.getInstance().completeAnOrder(ConsoleReader.getNextLong())){
            Printer.printMessage("Order was performed.");
        }else
            Printer.printMessage("Order wasn't performed.");

    }
}
