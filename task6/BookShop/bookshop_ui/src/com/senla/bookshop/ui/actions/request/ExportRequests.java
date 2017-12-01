package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class ExportRequests implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();

        Facade.getInstance().exportRequests(path);
    }
}
