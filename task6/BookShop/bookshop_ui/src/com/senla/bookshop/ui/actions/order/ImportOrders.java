package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;


public class ImportOrders implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();
        if(Facade.getInstance().importOrders(path))
            Printer.printMessage("Orders were imported.");
        else
            Printer.printMessage("Failed to import orders.");
    }
}
