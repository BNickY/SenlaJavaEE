package com.senla.bookshop.ui.entities;

import com.senla.bookshop.facade.Facade;
import com.senla.bookshop.ui.api.IObserver;
import com.senla.bookshop.utils.ConsoleReader;

public class MenuController implements IObserver {
    private Menu menu;

    public void run() {
        Facade.getInstance().load();
        Builder builder = new Builder();
        builder.buildMenu();
        Navigator navigator = new Navigator(builder.getRootMenu());
        navigator.addObserver(this);
        int menuPosition;
        do {
            navigator.printMenu();

            menuPosition = ConsoleReader.getNextInt();

            navigator.getCurrentMenu().getMenuItems().get(menuPosition - 1).doAction();
            navigator.navigate(menuPosition);
        } while (menu != null);
    }

    @Override
    public void handleEvent(Menu menu) {
        this.menu = menu;
    }

}
