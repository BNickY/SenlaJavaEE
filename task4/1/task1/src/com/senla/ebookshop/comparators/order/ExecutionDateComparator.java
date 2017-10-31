package com.senla.ebookshop.comparators.order;

import com.senla.ebookshop.model.Order;
import com.senla.ebookshop.utils.NullCompareUtil;
import java.util.Comparator;

public class ExecutionDateComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        int checkValue = NullCompareUtil.checkNullReference(o1,o2);
        if(checkValue == 2) {
            return o1.getExecutionDate().compareTo(o2.getExecutionDate());
        }
        return checkValue;
    }
}
