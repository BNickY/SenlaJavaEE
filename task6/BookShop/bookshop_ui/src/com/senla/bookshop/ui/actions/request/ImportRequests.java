package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ImportRequests implements IAction{
    private static final Logger LOGGER = LogManager.getLogger(ImportRequests.class);

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();

        try {
            Facade.getInstance().importRequests(path);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
