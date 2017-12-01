package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class ImportRequests implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();
        if(Facade.getInstance().importRequests(path))
            Printer.printMessage("Requests were imported.");
        else
            Printer.printMessage("Failed to import requests.");
    }
}