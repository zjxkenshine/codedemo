package com.kenshine.lunar.foto;

import com.nlf.calendar.Foto;
import com.nlf.calendar.FotoFestival;
import com.nlf.calendar.Lunar;

import java.util.Date;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 0:58
 * @description：佛历
 * @modified By：
 * @version: $
 */
public class FotoTest {
    public static void main(String[] args) {
        Foto d = Foto.fromLunar(Lunar.fromDate(new Date()));
        System.out.println(d);
        System.out.println(d.toFullString());

        System.out.println(d);
        System.out.println(d.toString());

        System.out.println(d.toFullString());

        // 年月日
        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getDay());

        System.out.println(d.getYearInChinese());
        System.out.println(d.getMonthInChinese());
        System.out.println(d.getDayInChinese());

        // 因果犯忌
        Foto d1 = Foto.fromLunar(Lunar.fromYmd(2021, 10, 14));
        List<FotoFestival> l = d1.getFestivals();
        for (FotoFestival f : l){
            System.out.println(f.toFullString());
        }

        // 纪念日
        Foto d2 = Foto.fromLunar(Lunar.fromYmd(2021, 2, 15));
        List<FotoFestival> l2 = d2.getFestivals();
        for (FotoFestival f : l2){
            System.out.println(f);
        }

        // 月斋
        System.out.println(d.isMonthZhai());

        // 官网
        // 十斋日
        //六斋日
        //朔望斋
        //观音斋
        //杨公忌
        //二十七星宿
        //转阴历
    }
}
