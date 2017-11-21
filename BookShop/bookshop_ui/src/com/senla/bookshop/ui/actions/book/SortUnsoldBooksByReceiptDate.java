package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.api.exeptions.DataNotExistException;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortUnsoldBooksByReceiptDate implements IAction{

    @Override
    public void execute() {
        try {
            Printer.printArray(Facade.getInstance().sortUnsoldBooksByReceiptDate());
        } catch (DataNotExistException e) {
            Printer.printMessage(e.getMessage());
        }
    }
}
