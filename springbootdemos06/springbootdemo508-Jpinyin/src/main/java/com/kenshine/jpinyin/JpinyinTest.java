package com.kenshine.jpinyin;

import opensource.jpinyin.ChineseHelper;
import opensource.jpinyin.PinyinFormat;
import opensource.jpinyin.PinyinHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JpinyinTest
 * @Description Jpinyin 中文转语音
 * @Date 2023-11-27 17:23
 * @modified By：
 * @version: 1.0$
 */
public class JpinyinTest {

    /**
     * ChineseHelper 简繁体转换
     */
    @Test
    public void test01(){
        String t=ChineseHelper.convertToTraditionalChinese("测试");
        String t1=ChineseHelper.convertToSimplifiedChinese(t);
        System.out.println(t);
        System.out.println(t1);
    }

    /**
     * PinyinHelper 汉字转拼音
     */
    @Test
    public void test02(){
        // 简写
        String py=PinyinHelper.getShortPinyin("测试");
        System.out.println(py);
        // 全拼，以,隔开
        String py1=PinyinHelper.convertToPinyinString("测试",",");
        System.out.println(py1);
        // convertToPinyinArray
        String[] py2=PinyinHelper.convertToPinyinArray('滚');
        System.out.println(Arrays.asList(py2));
        // PinyinFormat 格式
        String py3=PinyinHelper.convertToPinyinString("测试",",", PinyinFormat.WITH_TONE_NUMBER);
        System.out.println(py3);
    }
}
