package com.senla.bookshop.comparators.order;

import com.senla.bookshop.entities.Order;
import com.senla.bookshop.utils.ComparisonUtil;

import java.util.Comparator;

public class ExecutionDateComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        int checkValue = ComparisonUtil.compareNullRefernces(o1,o2);
        if(checkValue == 2) {
            return o1.getExecutionDate().compareTo(o2.getExecutionDate());
        }
        return checkValue;
    }
}
