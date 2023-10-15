package com.kenshine.lunar.tao;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Tao;
import com.nlf.calendar.TaoFestival;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 1:02
 * @description：道历
 * @modified By：
 * @version: $
 */
public class TaoTest {
    public static void main(String[] args) {
        Tao d = Tao.fromLunar(Lunar.fromDate(new Date()));
        System.out.println(d);
        System.out.println(d.toFullString());

        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getDay());

        System.out.println(d.getYearInChinese());
        System.out.println(d.getMonthInChinese());
        System.out.println(d.getDayInChinese());

        // 节日
        Tao d1 = Tao.fromLunar(Lunar.fromYmd(2021, 10, 14));
        List<TaoFestival> l = d1.getFestivals();
        for (TaoFestival s:l){
            System.out.println(s.getName());
        }

        // 三会日
        //三元日
        //八节日
        //五腊日
        //八会日
        //戊日
        //天赦日
        //转阴历
    }
}
