package com.senla.bookshop.comparators.book;

import com.senla.bookshop.entities.Book;
import com.senla.bookshop.utils.ComparisonUtil;
import java.util.Comparator;


public class ReceiptDateComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int checkValue = ComparisonUtil.compareNullRefernces(o1,o2);
        if(checkValue == 2) {
            return o1.getReceiptDate().compareTo(o2.getReceiptDate());
        }
        return checkValue;
    }
}
