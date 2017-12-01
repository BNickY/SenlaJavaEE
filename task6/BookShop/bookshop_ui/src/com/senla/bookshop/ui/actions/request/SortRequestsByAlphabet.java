package com.senla.bookshop.ui.actions.request;

import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.utils.Printer;

public class SortRequestsByAlphabet implements IAction{

    @Override
    public void execute() {
        Printer.printArray(Facade.getInstance().sortRequestsByAlphabet());
    }
}
