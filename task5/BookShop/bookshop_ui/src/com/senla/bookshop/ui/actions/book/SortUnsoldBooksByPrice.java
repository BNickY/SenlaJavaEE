package com.senla.bookshop.ui.actions.book;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printer;

public class SortUnsoldBooksByPrice implements IAction{
    @Override
    public void execute() {
        Printer.printArray(Facade.getInstance().sortUnsoldBooksByPrice());
    }
}
