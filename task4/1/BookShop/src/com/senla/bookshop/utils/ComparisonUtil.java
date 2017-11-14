package com.senla.bookshop.utils;

public class ComparisonUtil {

    public static int compareNullRefernces(Object o1, Object o2){
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null & o2 == null)
            return 0;
        return 2;
    }
}
