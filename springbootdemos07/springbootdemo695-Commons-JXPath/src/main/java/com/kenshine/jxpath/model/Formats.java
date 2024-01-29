package com.kenshine.jxpath.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义方法
 * @author kenshine
 */
public class Formats {
    public static String date(Date d, String pattern){
        return new SimpleDateFormat(pattern).format(d);
    }
 }