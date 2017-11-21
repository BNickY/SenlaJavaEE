package com.senla.bookshop.ui.api;

public interface IObservable {
    void addObserver(IObserver observer);

    void notifyObservers();
}
