package com.senla.bookshop.api.comparators.book;

import com.senla.bookshop.api.entities.IBook;

import java.util.Comparator;


public class ReceiptDateComparator implements Comparator<IBook> {

    @Override
    public int compare(IBook o1, IBook o2) {
        if(o1 == null ^ o2 == null)
            return (o1 == null) ? -1 : 1;
        if(o1 == null & o2 == null)
            return 0;

        return o1.getReceiptDate().compareTo(o2.getReceiptDate());
    }
}
