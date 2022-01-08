package com.kenshine.basic._01_base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 23:32
 * @description：
 * @modified By：
 * @version: $
 */
public class test10_DateCalendar {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    public static void main(String[] args) {
        SimpleDateFormat simple = new SimpleDateFormat(pattern);
        System.out.println(simple.format(new Date()));

        //Calendar
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,1);
        int year=calendar.get(Calendar.YEAR);
        System.out.println(year);
    }
}
