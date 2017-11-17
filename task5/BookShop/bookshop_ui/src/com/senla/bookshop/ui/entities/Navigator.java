package com.senla.bookshop.ui.entities;

import com.senla.bookshop.ui.api.IObservable;
import com.senla.bookshop.ui.api.IObserver;
import com.senla.bookshop.utils.Printer;
import java.util.ArrayList;
import java.util.List;

public class Navigator implements IObservable {
    private List<IObserver> observers;
    private Menu currentMenu;

    public Navigator(Menu currentMenu) {
        this.currentMenu = currentMenu;
        observers=new ArrayList<>();
    }

    public void printMenu() {
        Printer.printMessage(currentMenu.getName());
        int i = 1;
        for (MenuItem menuItem : currentMenu.getMenuItems()) {
            Printer.printMessage(i++ + "." + menuItem.getTitle());
        }
        Printer.printMessage("==================================");
    }

    public void navigate(Integer index) {
        setCurrentMenu( currentMenu.getMenuItems().get(index - 1).getNextMenu());
    }

    private void setCurrentMenu(Menu menu) {
        currentMenu = menu;
        notifyObservers();
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer:observers) {
            observer.handleEvent(currentMenu);
        }
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

}
