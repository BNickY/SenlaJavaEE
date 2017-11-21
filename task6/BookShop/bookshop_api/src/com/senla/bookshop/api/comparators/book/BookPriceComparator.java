package com.senla.bookshop.api.comparators.book;

import com.senla.bookshop.api.entities.IBook;
import java.util.Comparator;

public class BookPriceComparator implements Comparator<IBook> {

    @Override
    public int compare(IBook o1, IBook o2) {
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null & o2 == null)
            return 0;
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}