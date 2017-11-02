package com.senla.bookshop.comparators.request;


import com.senla.bookshop.entities.Request;
import com.senla.bookshop.utils.ComparisonUtil;

import java.util.Comparator;

public class RequestAmountComparator implements Comparator<Request>{

    @Override
    public int compare(Request o1, Request o2) {
        int checkValue = ComparisonUtil.compareNullRefernces(o1,o2);
        if(checkValue == 2) {
            return o1.getBook().getAmountOfRequests() - o2.getBook().getAmountOfRequests();
        }
        return checkValue;
    }
}
