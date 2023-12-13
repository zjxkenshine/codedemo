package com.kenshine.dsiutils;

import com.martiansoftware.jsap.ParseException;
import it.unimi.dsi.lang.EnumStringParser;
import it.unimi.dsi.lang.ObjectParser;
import it.unimi.dsi.stat.Jackknife;
import it.unimi.dsi.util.Interval;
import it.unimi.dsi.util.KahanSummation;
import it.unimi.dsi.util.SplitMix64Random;
import it.unimi.dsi.util.XoRoShiRo128PlusRandom;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * @author by kenshine
 * @Classname DsiutilsTest03
 * @Description 其他测试
 * @Date 2023-12-13 17:03
 * @modified By：
 * @version: 1.0$
 */
public class DsiutilsTest03 {
    public enum TestEnum {
        A,
        b,
        C
    }

    /**
     *  EnumStringParser
     */
    @Test
    public void test01() throws ParseException {
        final EnumStringParser<TestEnum> enumStringParser = EnumStringParser.getParser(TestEnum.class);
        System.out.println(enumStringParser.parse("A"));
        System.out.println(enumStringParser.parse("b"));
        System.out.println(enumStringParser.parse("C"));
    }

    /**
     * ObjectParser 对象解析
     */
    @Test
    public void test02() throws IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Object o =ObjectParser.fromSpec("java.lang.Object").getClass();
        System.out.println(ObjectParser.fromSpec("java.lang.String(foo)"));
    }

    /**
     * Interval 整数间的距离
     */
    @Test
    public void test03(){
        // 1
        System.out.println(Interval.valueOf(0).length());
        // 112
        System.out.println(Interval.valueOf(0,111).size());
    }

    /**
     * KahanSummation 求和
     */
    @Test
    public void test04(){
        final KahanSummation sum = new KahanSummation();
        sum.add(1);
        sum.add(2);
        sum.add(3);
        System.out.println(sum.value());
    }

    /**
     * SplitMix64Random 随机数生成
     */
    @Test
    public void test05(){
        final SplitMix64Random splitMixRandom = new SplitMix64Random(1024);
        System.out.println(splitMixRandom.nextFloat());
        System.out.println(splitMixRandom.nextFloat());
        System.out.println(splitMixRandom.nextFloat());
    }

    /**
     * XoRoShiRo128PlusRandom 随机数生成
     */
    @Test
    public void test06(){
        XoRoShiRo128PlusRandom xoroRandom = new XoRoShiRo128PlusRandom();
        // 生成100-200 之间的随机数
        int randomWithXoRoShiRo128PlusRandom = xoroRandom.nextInt(100) + 100;
        System.out.println(randomWithXoRoShiRo128PlusRandom);
    }





}
