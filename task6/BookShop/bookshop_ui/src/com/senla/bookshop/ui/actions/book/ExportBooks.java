package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class ExportBooks implements IAction{

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();
        if(Facade.getInstance().exportBooks(path))
            Printer.printMessage("Books were exported.");
        else
            Printer.printMessage("File that you input doesn't exists.");
    }
}
