package com.senla.bookshop.config;

import java.util.Properties;

public class PropertyStorage {
    private static final int DEFAULT_MONTHS_TO_SALE = 6;
    private static final boolean DEFAULT_IS_REQUEST_MARKED = true;
    private static final String DEFAULT_DATA_FILE_PATH = "data.txt";
    private static PropertyStorage propertyStorage;
    private int monthsToSale;
    private boolean isRequestMarked;
    private String dataFilePath;

    private PropertyStorage() {}

    private void getProperties(){
        Properties properties = PropertyReader.getPropertiesFromFile();
        if(properties != null){
            monthsToSale = Integer.parseInt(properties.getProperty("monthsToSale"));
            isRequestMarked = Boolean.parseBoolean(properties.getProperty("markRequest"));
            dataFilePath = properties.getProperty("dataFilePath");
        }else {
            monthsToSale = DEFAULT_MONTHS_TO_SALE;
            isRequestMarked = DEFAULT_IS_REQUEST_MARKED;
            dataFilePath = DEFAULT_DATA_FILE_PATH;
        }
    }

    public static PropertyStorage getInstance(){
        if(propertyStorage == null) {
            propertyStorage = new PropertyStorage();
            propertyStorage.getProperties();
        }
        return propertyStorage;
    }

    public String getDataFilePath() {
        return dataFilePath;
    }

    public int getMonthsToSale(){
        return monthsToSale;
    }

    public boolean isRequestMarked() {
        return isRequestMarked;
    }
}
