package com.senla.bookshop.ui.actions.order;

import com.senla.bookshop.api.exeptions.DataNotExistException;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetOrder implements IAction{

    private static final Logger LOGGER = LogManager.getLogger(GetOrder.class);

    @Override
    public void execute() {
        Facade facade = Facade.getInstance();
        try {
            Printer.printArray(facade.getAllOrders());
            Printer.printMessage("\nEnter order id to get description: ");
            Printer.printEntity(facade.getOrder(ConsoleReader.getNextLong()));
        } catch (DataNotExistException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
