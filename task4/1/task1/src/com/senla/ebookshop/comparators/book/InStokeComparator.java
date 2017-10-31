package com.senla.ebookshop.comparators.book;

import com.senla.ebookshop.model.Book;
import com.senla.ebookshop.utils.NullCompareUtil;
import java.util.Comparator;

public class InStokeComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        int checkValue = NullCompareUtil.checkNullReference(o1,o2);
        if(checkValue == 2) {
            return o1.getInStoke().compareTo(o2.getInStoke());
        }
        return checkValue;
    }
}
