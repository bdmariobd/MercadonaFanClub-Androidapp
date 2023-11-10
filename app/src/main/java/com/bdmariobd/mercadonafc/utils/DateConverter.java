package com.bdmariobd.mercadonafc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    public static String convertToFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        if (date == null) {
            return sdf.format(new Date());
        }
        return sdf.format(date);
    }
}
