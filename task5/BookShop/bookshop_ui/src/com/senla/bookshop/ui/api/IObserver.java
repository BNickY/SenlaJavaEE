package com.senla.bookshop.ui.api;

import com.senla.bookshop.ui.entities.Menu;

public interface IObserver {
    void handleEvent(Menu menu);
}