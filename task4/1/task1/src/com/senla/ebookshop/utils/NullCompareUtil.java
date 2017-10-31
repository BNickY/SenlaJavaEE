package com.senla.ebookshop.utils;

public class NullCompareUtil {

    public static int checkNullReference(Object o1, Object o2){
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null && o2 == null)
            return 0;
        return 2;
    }
}
