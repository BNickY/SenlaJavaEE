package com.senla.bookshop.ui.actions.exit;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IAction;
import com.senla.bookshop.utils.Printer;

public class ExitAction implements IAction{
    @Override
    public void execute() {
        Facade.getInstance().exit();
    }
}
