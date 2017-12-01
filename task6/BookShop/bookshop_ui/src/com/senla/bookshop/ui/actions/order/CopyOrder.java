package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;


public class CopyOrder implements IAction{

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        Printer.printArray(facade.getAllOrders());
        Printer.printMessage("\nChoose order to clone (enter order id): ");
        Order sourceOrder = (Order) facade.getOrder(ConsoleReader.getNextLong());
        if(sourceOrder != null) {
            Order copiedOrder;
            try {
                copiedOrder = sourceOrder.clone();
                facade.addOrder(copiedOrder);
                Printer.printMessage("The order was copied");
            } catch (CloneNotSupportedException e) {
                Printer.printMessage("Can't copy the order.");
            }
        }else
            Printer.printMessage("There is no such order.");
    }
}
