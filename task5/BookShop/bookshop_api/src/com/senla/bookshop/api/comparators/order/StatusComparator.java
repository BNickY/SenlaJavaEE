package com.senla.bookshop.api.comparators.order;

import com.senla.bookshop.api.entities.IOrder;
import java.util.Comparator;

public class StatusComparator implements Comparator<IOrder>{

    @Override
    public int compare(IOrder o1, IOrder o2) {
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null & o2 == null)
            return 0;

        return o1.getOrderStatus().compareTo(o2.getOrderStatus());
    }
}
