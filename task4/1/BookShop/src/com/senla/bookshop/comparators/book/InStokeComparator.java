package com.senla.bookshop.comparators.book;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.utils.ComparisonUtil;

import java.util.Comparator;

public class InStokeComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int checkValue = ComparisonUtil.compareNullRefernces(o1,o2);
        if(checkValue == 2) {
            return o1.getInStoke().compareTo(o2.getInStoke());
        }
        return checkValue;
    }
}