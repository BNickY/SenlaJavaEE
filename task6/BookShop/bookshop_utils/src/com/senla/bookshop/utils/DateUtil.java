package com.senla.bookshop.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    private static final LocalDate TODAY_DATE = LocalDate.now();

    public static long getMonthsDifference(LocalDate localDate){
        return Math.abs(ChronoUnit.MONTHS.between(localDate,TODAY_DATE));
    }
}
