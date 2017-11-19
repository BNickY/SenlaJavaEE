package com.senla.bookshop.ui.entities;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IObserver;
import com.senla.bookshop.utils.ConsoleReader;
import com.senla.bookshop.utils.Printer;

public class MenuController implements IObserver {
    private Menu menu;

    public void run() {
        Facade.getInstance().load();
        Builder builder = new Builder();
        builder.buildMenu();
        menu = builder.getRootMenu();
        Navigator navigator = new Navigator(menu);
        navigator.addObserver(this);
        int menuPosition;
        do {
            navigator.printMenu();

            menuPosition = ConsoleReader.getNextInt();

            if (menuPosition > 0 &&
                    menuPosition <= navigator.getCurrentMenu().getMenuItems().size()) {
                navigator.getCurrentMenu().getMenuItems().get(menuPosition - 1).doAction();
                navigator.navigate(menuPosition);
            }else Printer.printMessage("There is no such menu! Try again.");
        } while (menu != null);
    }

    @Override
    public void handleEvent(Menu menu) {
        this.menu = menu;
    }

}
