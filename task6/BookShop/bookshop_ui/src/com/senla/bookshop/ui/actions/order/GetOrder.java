package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.api.entities.IOrder;
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
        IOrder order = facade.getOrder(ConsoleReader.getNextLong());
        if(order != null) {
            Printer.printEntity(order);
        }else
            Printer.printMessage("There is no order with such id!");
    }
}
