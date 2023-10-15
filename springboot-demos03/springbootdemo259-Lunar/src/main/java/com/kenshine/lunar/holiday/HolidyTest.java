package com.kenshine.lunar.holiday;

import com.nlf.calendar.Holiday;
import com.nlf.calendar.util.HolidayUtil;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 1:04
 * @description：节假日
 * @modified By：
 * @version: $
 */
public class HolidyTest {
    public static void main(String[] args) {
        List<Holiday> holidays = HolidayUtil.getHolidays(2020);
        List<Holiday> holidays1 = HolidayUtil.getHolidays(2011);
        System.out.println(holidays);
        System.out.println(holidays1);

        // 将2020-01-01修改为春节，并追加2099-01-01为元旦节
        HolidayUtil.fix("202001011120200101209901010120990101");

        // 将元旦节改为元旦
        String[] names = HolidayUtil.NAMES;
        names[0] = "元旦";
        HolidayUtil.fix(names, null);

        // 指定日期是否放假
        Holiday d = HolidayUtil.getHoliday(2020,5,2);
        System.out.println(d.isWork());

        // 指定月份的假期
        //指定年份的假期
        //节日相关的假期
    }
}
