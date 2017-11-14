package com.senla.bookshop.utils;

import com.senla.bookshop.api.entities.IEntity;
import java.util.List;

public class Printer {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printEntity(IEntity entity){
        System.out.println(entity);
    }

    public static void printArray(List<? extends IEntity> objectList){
        for(IEntity i: objectList){
                System.out.println(i);
        }
    }
}
