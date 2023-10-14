package com.kenshine.xktime;

import com.xkzhangsan.time.LunarDate;
import com.xkzhangsan.time.calculator.DateTimeCalculatorUtil;
import com.xkzhangsan.time.calendar.CalendarUtil;
import com.xkzhangsan.time.calendar.CalendarWrapper;
import com.xkzhangsan.time.calendar.DayWrapper;
import com.xkzhangsan.time.converter.DateTimeConverterUtil;
import com.xkzhangsan.time.cron.CronExpressionUtil;
import com.xkzhangsan.time.formatter.DateTimeFormatterUtil;
import com.xkzhangsan.time.holiday.Holiday;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.*;
import java.util.Date;
import java.util.List;

/**
 * @author by kenshine
 * @Classname Test01DateTimeConverterUtil
 * @Description 工具类测试
 * @Date 2023-10-14 13:21
 * @modified By：
 * @version: 1.0$
 */
public class xkTimeTest {

    /**
     * 日期转换工具类 DateTimeConverterUtil
     */
    @Test
    public void testDateTimeConverterUtil(){
        Date date=DateTimeConverterUtil.toDate(LocalDate.now());
        LocalDateTime ldt=DateTimeConverterUtil.toLocalDateTime(LocalTime.now());
        //毫秒时间戳
        Long l=DateTimeConverterUtil.toEpochMilli(LocalDateTime.now());
        // 时间戳
        Instant instant=DateTimeConverterUtil.toInstant(LocalDateTime.now());
        YearMonth yearMonth=DateTimeConverterUtil.toYearMonth(LocalDate.now());
        Timestamp timestamp=DateTimeConverterUtil.toTimestamp(LocalDateTime.now());
        ZonedDateTime zonedDateTime=DateTimeConverterUtil.toZonedDateTime(LocalDateTime.now());
        //....
    }

    /**
     * 日期计算工具类 DateTimeCalculatorUtil
     */
    @Test
    public void testDateTimeCalculatorUtil(){
        long a=DateTimeCalculatorUtil.betweenDays(LocalDate.now(),LocalDate.parse("2023-11-08"));
        Date date=DateTimeCalculatorUtil.endTimeOfToday();
        int age =DateTimeCalculatorUtil.getAge(LocalDate.parse("2000-11-11"));
        int year = DateTimeCalculatorUtil.getYear(LocalDateTime.now());
        LocalDate date1=DateTimeCalculatorUtil.plusDays(LocalDate.now(),10);
        LocalDate date2=DateTimeCalculatorUtil.minusWeeks(LocalDate.now(),100);
        //减少时间精度
        LocalDateTime lc=DateTimeCalculatorUtil.reduceAccuracyToMinute(LocalDateTime.now());
        // 时区转换计算方法transform
        // get*List 计算指定年月的时间列表
        List<Date> dateList= DateTimeCalculatorUtil.getDateList("2023-11");
        //....
    }

    /**
     * yyyy-MM-dd
     * HH:mm:ss
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM-dd HH:mm:ss.SSS
     * yyyy-MM-dd HH:mm:ss.SSSSSS
     * yyyy-MM-dd HH:mm:ss.SSSSSSSSS
     * yyyy-MM-dd'T'HH:mm:ssZ
     * 日期格式化和解析工具类 DateTimeFormatterUtil
     */
    @Test
    public void testDateTimeFormatterUtil(){
        // yyyy-MM-dd
        String time1 = DateTimeFormatterUtil.format(LocalDate.now(), DateTimeFormatterUtil.YYYY_MM_DD_FMT);
        // yyyy/MM/dd
        String time2 = DateTimeFormatterUtil.format(LocalDate.now(), DateTimeFormatterUtil.YYYY_MM_DD_EN_FMT);
        // 年月日
        String time3 = DateTimeFormatterUtil.format(LocalDate.now(), DateTimeFormatterUtil.YYYY_MM_DD_CN_FMT);
        // 2020-05-23 星期六
        String time4 = DateTimeFormatterUtil.format(LocalDate.now(), DateTimeFormatterUtil.YYYY_MM_DD_E_FMT);
        // 05/23
        String time5 = DateTimeFormatterUtil.format(LocalDate.now(), DateTimeFormatterUtil.MM_DD_EN_FMT);
        // 2020-05-23 17:06:30.272150620
        String time6=DateTimeFormatterUtil.format(LocalDateTime.now(), DateTimeFormatterUtil.YYYY_MM_DD_HH_MM_SS_SSSSSSSSS_FMT);
        // ... dateFormatPattern可以自定义格式与解析
    }

    /**
     * CalendarUtil 日历工具类
     * 生成指定时间的日历（包含年、月和日层级关系的日历）
     */
    @Test
    public void testCalendarUtil(){
        List<DayWrapper> dayList = CalendarUtil.generateCalendar(2022).getDayList();
        // 生成指定年月的日历，包含农历和所有节假日信息 可以自定义节假日和工作日等
        CalendarWrapper cw = CalendarUtil.generateCalendarWithHoliday(2022,2);
    }

    /**
     * 农历日期类
     */
    @Test
    public void testLunarDate(){
        LunarDate lunarDate= LunarDate.now();
        LunarDate lunarDate1=LunarDate.from(LocalDate.parse("2023-05-26"));
    }

    /**
     *节假日计算类
     */
    @Test
    public void testHoliday(){
        String h1=Holiday.getLocalHoliday(LocalDate.now());
        String h2=Holiday.getChineseHoliday(LocalDate.now());
        // 二十四节气
        String h3=Holiday.getSolarTerm(LocalDate.now());
    }

    /**
     * Cron表达式工具类
     *
     * cron表达式从左到右（用空格隔开）：秒（0-59） 分（0-59） 小时（0-23） 日期（1-31） 月份（1-12的整数或者 JAN-DEC） 星期（1-7的整数或者 SUN-SAT （1=SUN）） 年份（可选，1970-2099）
     * 所有字段均可使用特殊字符：, - * / 分别是枚举，范围，任意，间隔
     * 日期另外可使用：? L W 分别是任意，最后，有效工作日(周一到周五)
     * 星期另外可使用：? L # 分别是任意，最后，每个月第几个星期几
     *
     （1）0 0 2 1 * ? * 表示在每月的1日的凌晨2点触发
     （2）0 15 10 ? * MON-FRI 表示周一到周五每天上午10:15执行作业
     （3）0 15 10 ? * 6L 2002-2006 表示2002-2006年的每个月的最后一个星期五上午10:15执行作
     （4）0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
     （5）0 15 10 L * ? 每月最后一日的上午10:15触发
     （6）0 15 10 ? * 6#3 每月的第三个星期五上午10:15触发
     */
    @Test
    public void testCronExpressionUtil(){
        String str1 =CronExpressionUtil.formatExpression("0 0 2 1 * ? *");
        Date date = CronExpressionUtil.getNextTime("0 0 2 1 * ? *");
        List<String> str = CronExpressionUtil.getNextTimeStrList("0 15 10 L * ?",new Date(),10);
    }
}
