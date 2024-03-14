package com.kenshine.mmseg4j;

import com.chenlb.mmseg4j.example.Complex;
import com.chenlb.mmseg4j.example.MaxWord;
import com.chenlb.mmseg4j.example.Simple;
import org.junit.Test;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Mmseg4jTest
 * @Description 使用测试
 * @Date 2024-03-14 10:41
 * @modified By：
 * @version: 1.0$
 */
public class Mmseg4jTest {

    /**
     * ComplexSeg 复杂分词
     */
    @Test
    public void test01() throws IOException {
        Complex segW = new Complex();
        String words = segW.segWords("俄罗斯跟乌克兰打起来了", "|");
        System.out.println(words);

        String words2 = segW.segWords("清华大学是北京地区的大学", "#");
        System.out.println(words2);
    }

    /**
     * MaxWord 匹配
     */
    @Test
    public void test02() throws IOException {
        MaxWord segW = new MaxWord ();
        String words = segW.segWords("俄罗斯跟乌克兰打起来了", "|");
        System.out.println(words);

        String words2 = segW.segWords("清华大学是北京地区的大学", "#");
        System.out.println(words2);
    }

    /**
     * Simple 简单分词
     */
    @Test
    public void test03() throws IOException {
        Simple segW = new Simple();
        String words = segW.segWords("俄罗斯跟乌克兰打起来了", "|");
        System.out.println(words);

        String words2 = segW.segWords("清华大学是北京地区的大学", "#");
        System.out.println(words2);
    }

}
