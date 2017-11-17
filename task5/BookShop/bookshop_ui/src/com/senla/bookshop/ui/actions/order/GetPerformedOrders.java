package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

import java.time.LocalDate;

public class GetPerformedOrders implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Enter start date (yyyy-MM-dd): ");
        LocalDate start = ConsoleReader.getDate();
        Printer.printMessage("Enter end date (yyyy-MM-dd): ");
        LocalDate end = ConsoleReader.getDate();
        Printer.printArray(Facade.getInstance().getPerformedOrders(start,end));
    }
}
