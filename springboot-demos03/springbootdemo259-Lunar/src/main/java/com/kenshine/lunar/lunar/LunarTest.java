package com.kenshine.lunar.lunar;

import com.nlf.calendar.Lunar;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 0:54
 * @description：农历
 * @modified By：
 * @version: $
 */
public class LunarTest {
    public static void main(String[] args) {
        Lunar d = Lunar.fromDate(new Date());

        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getDay());

        System.out.println(d.getYearInChinese());
        System.out.println(d.getMonthInChinese());
        System.out.println(d.getDayInChinese());

        // 获取年月日
        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getDay());
        System.out.println(d.getYearInChinese());
        System.out.println(d.getMonthInChinese());
        System.out.println(d.getDayInChinese());

        // 时辰
        System.out.println(d.getTimeGan());
        System.out.println(d.getTimeZhi());
        System.out.println(d.getTimeInGanZhi());
        System.out.println(d.getTimeShengXiao());

        // 星期
        System.out.println(d.getWeek());
        System.out.println(d.getWeekInChinese());

        // 节日
        Lunar d1 = Lunar.fromYmd(2016, 2, 2);
        List<String> l = d1.getFestivals(); // 常用节日
        for (String s:l){
            System.out.println(s);
        }
        l = d1.getOtherFestivals();  //其他节日
        for (String s:l){
            System.out.println(s);
        }
        // 其他查看官网
        // 干支
        //禄
        //生肖
        //节气
        //物候
        //数九
        //三伏
        //六曜
        //二十八星宿
        //七政(七曜)
        //四宫
        //四神兽
        //彭祖百忌
        //八卦方位
        //吉神方位
        //胎神方位
        //太岁方位
        //冲煞
        //纳音
        //八字
        //十神
        //旬、旬空(空亡)
        //建除十二值星
        //十二天神
        //每日宜忌
        //时辰宜忌
        //吉神凶煞
        //月相
        //九星
        //日期推移
        //转阳历
        //转佛历
        //转道历
    }
}
