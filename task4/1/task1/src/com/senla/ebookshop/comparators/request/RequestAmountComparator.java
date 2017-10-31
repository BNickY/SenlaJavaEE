package com.senla.ebookshop.comparators.request;

import com.senla.ebookshop.model.Request;
import com.senla.ebookshop.utils.NullCompareUtil;

import java.util.Comparator;

public class RequestAmountComparator implements Comparator<Request>{

    @Override
    public int compare(Request o1, Request o2) {
        int checkValue = NullCompareUtil.checkNullReference(o1,o2);
        if(checkValue == 2) {
            return o1.getBook().getAmountOfRequests() - o2.getBook().getAmountOfRequests();
        }
        return checkValue;
    }
}
