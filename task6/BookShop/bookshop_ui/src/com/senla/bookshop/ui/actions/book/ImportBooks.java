package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ImportBooks implements IAction{

    private static final Logger LOGGER = LogManager.getLogger(ImportBooks.class);

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();

        try {
            Facade.getInstance().importBooks(path);
        } catch(NumberFormatException | IOException e) {
            LOGGER.error(e);
        }
    }
}
