package com.senla.bookshop.api.comparators.order;

import com.senla.bookshop.api.entities.IOrder;
import java.util.Comparator;

public class OrderPriceComparator implements Comparator<IOrder>{

    @Override
    public int compare(IOrder o1, IOrder o2) {
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null & o2 == null)
            return 0;

        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
