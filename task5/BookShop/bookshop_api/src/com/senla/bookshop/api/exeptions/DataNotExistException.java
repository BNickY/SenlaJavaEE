package com.senla.bookshop.api.exeptions;

public class DataNotExistException extends Exception{

    public DataNotExistException(String message) {
        super(message);
    }
}
