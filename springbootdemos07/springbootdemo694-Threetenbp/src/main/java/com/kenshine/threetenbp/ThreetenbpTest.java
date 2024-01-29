package com.kenshine.threetenbp;

import org.junit.Test;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;


/**
 * @author by kenshine
 * @Classname ThreetenbpTest
 * @Description 测试
 * @Date 2024-01-29 8:28
 * @modified By：
 * @version: 1.0$
 */
public class ThreetenbpTest {

    /**
     * 使用
     */
    @Test
    public void test01(){
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate currentDate = LocalDate.parse("2024-01-29");
        // 时间直接加日期 当前日期 30天后的日期
        LocalDate localDate = currentDate.plusDays(30);
        System.out.println(localDate);
        // 日期格式化
        LocalDate parse1 = LocalDate.parse("20240129", DATE_TIME_FORMATTER);
        System.out.println(parse1);
        // 判断两个时间是否相等
        boolean equals = parse1.equals(currentDate);
        System.out.println(equals);
        // 判断localDate是否在当前日期之后
        boolean after = localDate.isAfter(currentDate);
        // 当前日期减一天
        LocalDate minus = currentDate.minusDays(1L);
        System.out.println(minus);
        // 纪元日
        long l = currentDate.toEpochDay();
        System.out.println(currentDate.toEpochDay());

        System.out.println(after);
    }
}
