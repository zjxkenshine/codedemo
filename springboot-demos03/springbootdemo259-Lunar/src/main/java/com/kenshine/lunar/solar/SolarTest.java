package com.kenshine.lunar.solar;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 0:42
 * @description： 阳历
 * @modified By：
 * @version: $
 */
public class SolarTest {
    public static void main(String[] args) {
        // 年月日
        Solar d = Solar.fromYmd(2016, 1, 1);
        System.out.println(d);

        // 年月日时分秒
        d = Solar.fromYmdHms(2016, 1, 1, 20, 35, 0);
        System.out.println(d);

        // 日期
        d = Solar.fromDate(new Date());
        System.out.println(d.toFullString());

        // 儒略日
        d = Solar.fromJulianDay(2458960.5);
        System.out.println(d.toFullString());

        // 八字反推阳历
        List<Solar> l = Solar.fromBaZi("庚子", "辛巳", "庚午", "丙子");
        for (Solar solar : l) {
            System.out.println(solar.toFullString());
        }

        // 默认字符串输出
        System.out.println(d);
        System.out.println(d.toString());

        // YYYY-MM-DD
        System.out.println(d.toYmd());

        // YYYY-MM-DD HH:mm:ss
        System.out.println(d.toYmdHms());

        // 全量字符串输出
        System.out.println(d.toFullString());

        // 星期
        System.out.println(d.getWeek());
        System.out.println(d.getWeekInChinese());

        // 闰年
        System.out.println(d.isLeapYear());

        // 星座
        System.out.println(d.getXingZuo());

        // 往后推两天，即后天
        System.out.println(d.next(2));

        // 往前推1天，即昨天
        System.out.println(d.next(-1));

        // 往后推2个工作日
        System.out.println(d.next(2, true));

        // 往前推1个工作日
        System.out.println(d.next(-1, true));

        // 日期差
        Solar a = Solar.fromYmd(1582, 10, 15);
        Solar b = Solar.fromYmd(1582, 10, 4);
        System.out.println(a.subtract(b));  // 相减
        System.out.println(a.isBefore(b));  // 比较

        // 薪资比例
        System.out.println(d.getSalaryRate());

        // 转阴历
        Lunar lunar = d.getLunar();
        System.out.println(lunar.toString());
        System.out.println(lunar.toFullString());
    }
}
