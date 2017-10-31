package com.senla.ebookshop.utils;

public class Printer {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printObject(Object object){
        System.out.println(object);
    }

    public static void printArray(Object[] objects){
        for(Object i: objects){
             System.out.println(i);
        }
    }

}
