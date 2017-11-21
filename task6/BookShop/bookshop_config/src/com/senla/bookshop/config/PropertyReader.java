package com.senla.bookshop.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Logger LOGGER = LogManager.getLogger(PropertyReader.class);
    private static final String PATH_TO_PROPERTIES = "config/config.properties";

    public static Properties getPropertiesFromFile(){
        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)){
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e){
            LOGGER.error(e);
            return null;
        }
    }
}
