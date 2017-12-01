package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class ExportOrders implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();
        if(Facade.getInstance().exportOrders(path))
            Printer.printMessage("Orders were exported.");
        else
            Printer.printMessage("File that you input doesn't exists.");
    }
}
