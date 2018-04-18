package com.auro.test.utility.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {
    public static Date nextDate(Date currentDate) {
        Calendar seekedDate = Calendar.getInstance();
        seekedDate.setTime(currentDate);
        seekedDate.set(Calendar.DAY_OF_MONTH, seekedDate.get(Calendar.DAY_OF_MONTH)+1);
        return seekedDate.getTime();
    }
    public static long findDays(Date date1, Date date2) {
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public static Date todayOnlyDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        return formatter.parse(formatter.format(today));
    }
}
