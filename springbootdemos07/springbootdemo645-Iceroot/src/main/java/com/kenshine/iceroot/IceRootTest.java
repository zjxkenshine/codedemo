package com.kenshine.iceroot;

import com.icexxx.util.IceConst;
import com.icexxx.util.IceUtil;

import java.util.Arrays;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2024/1/1 21:41
 * @description：iceroot使用测试
 * @modified By：
 * @version: $
 */
public class IceRootTest {
    public static void main(String[] args) {
        // 日期解析
        System.out.println(IceUtil.parseDate("2017-01-01 23:59:59"));
        System.out.println(IceUtil.parseDate("2017-01-01", IceConst.DATE_SHORT_FORMAT));
        // 日期格式化
        System.out.println(IceUtil.formatDate(new Date(), IceConst.DATE_LONG_FORMAT));
        System.out.println(IceUtil.formatDate(new Date(), IceConst.DATE_SHORT_FORMAT));
        // String数组转为Integer数组
        System.out.println(Arrays.toString(IceUtil.convert2Int(new String[] { "123", "456", "789", null })));
        // 获取数组的第一个元素
        System.out.println(IceUtil.first(new String[] { "123", "456", "789", null }));
        System.out.println(IceUtil.first(new String[] {}));
        // 生成uuid
        System.out.println(IceUtil.uuid());
        // 手机号脱敏
        System.out.println(IceUtil.mistWord("13512345678", 3, 7));// 135****678
        // 判断是否为闰年
        System.out.println(IceUtil.isLeapYear(1900));// false
        System.out.println(IceUtil.isLeapYear(2000));// true
        System.out.println(IceUtil.isLeapYear(2001));// false
        System.out.println(IceUtil.isLeapYear(1600));// true
        // 根据精确的历法，3200的倍数是平年
        System.out.println(IceUtil.isLeapYear(3200));// false
        // 1582年以前只要是4的倍数就是闰年
        System.out.println(IceUtil.isLeapYear(1300));// true
        // 判断每月的最后一天
        System.out.println(IceUtil.monthDays(2000, 2));// 29
        // 时分秒转秒数
        System.out.println(IceUtil.time2second("01:00:01"));// 3601
        // 秒数转时分秒
        System.out.println(IceUtil.second2time(3602));// 01:00:02
        // 四色五入,保留两位小数
        System.out.println(IceUtil.round(3.1415926));// 3.14
        // 字符串转int
        System.out.println(IceUtil.toInt("123", 0));// 123
        System.out.println(IceUtil.toInt("", 0));// 0
        // url转map {username=zs, password=test}
        System.out.println(IceUtil.url2map("http://localhost:8080/web?username=zs&password=test"));
        // 计算日期相差的天数
        Date date1 = IceUtil.parseDate("2016-12-31 23:59:59", IceConst.DATE_LONG_FORMAT);
        Date date2 = IceUtil.parseDate("2017-01-01 00:00:01", IceConst.DATE_LONG_FORMAT);
        System.out.println(IceUtil.dayLength(date1, date2));// 1
    }
}
