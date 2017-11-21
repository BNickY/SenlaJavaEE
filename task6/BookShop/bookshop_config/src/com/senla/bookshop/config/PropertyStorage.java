package com.senla.bookshop.config;
import java.util.Properties;

public class PropertyStorage {
    private static final int DEFAULT_MONTHS_TO_SALE = 6;
    private static final boolean DEFAULT_IS_REQUEST_MARKED = true;
    private static PropertyStorage propertyStorage;
    private int monthsToSale;
    private boolean isRequestMarked;

    private PropertyStorage() {
        getProperties();
    }

    public static synchronized PropertyStorage getInstance(){
        if(propertyStorage == null) {
            propertyStorage = new PropertyStorage();
        }
        return propertyStorage;
    }

    private void getProperties(){
        Properties properties = PropertyReader.getPropertiesFromFile();
        if(properties != null){
            monthsToSale = Integer.parseInt(properties.getProperty("monthsToSale"));
            isRequestMarked = Boolean.parseBoolean(properties.getProperty("markRequest"));
        }else {
            monthsToSale = DEFAULT_MONTHS_TO_SALE;
            isRequestMarked = DEFAULT_IS_REQUEST_MARKED;
        }
    }

    public int getMonthsToSale(){
        return monthsToSale;
    }

    public boolean isRequestMarked() {
        return isRequestMarked;
    }
}
