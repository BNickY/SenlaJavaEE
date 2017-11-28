package com.senla.bookshop.ui.actions.order;


import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class ExportOrders implements IAction{
    private static final Logger LOGGER = LogManager.getLogger(ExportOrders.class);

    @Override
    public void execute() {
        Printer.printMessage("Input file path: ");
        String path = ConsoleReader.getNextLine();

        try {
            Facade.getInstance().exportOrders(path);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
