package com.kenshine.wordchecker;

import com.github.houbb.word.checker.util.WordCheckerHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname WCTest
 * @Description 中文检测
 * @Date 2023-11-10 8:26
 * @modified By：
 * @version: 1.0$
 */
public class WCZHTest {

    /**
     * 判断是否正确
     */
    @Test
    public void test01(){
        final String right = "正确";
        final String error = "万变不离其中";
        Assert.assertTrue(WordCheckerHelper.isCorrect(right));
        Assert.assertFalse(WordCheckerHelper.isCorrect(error));
    }

    /**
     * 最佳匹配结果
     */
    @Test
    public void test02(){
        final String right = "正确";
        final String error = "万变不离其中";
        Assert.assertEquals("正确", WordCheckerHelper.correct(right));
        Assert.assertEquals("万变不离其宗", WordCheckerHelper.correct(error));
    }

    /**
     * 默认纠正匹配列表
     */
    @Test
    public void test03(){
        final String word = "万变不离其中";
        List<String> stringList = WordCheckerHelper.correctList(word);
        System.out.println(stringList.toString());
    }

    /**
     * 指定纠正匹配列表大小
     */
    @Test
    public void test04(){
        final String word = "万变不离其中";
        final int limit = 2;
        List<String> stringList = WordCheckerHelper.correctList(word, limit);
        // [万变不离其宗]
        System.out.println(stringList.toString());
    }

    /**
     * 中英文
     */
    @Test
    public void test05(){
        final String hello = "hello 你好";
        final String speling = "speling 你好 以毒功毒";
        Assert.assertTrue(WordCheckerHelper.isCorrect(hello));
        Assert.assertFalse(WordCheckerHelper.isCorrect(speling));
    }

    /**
     * 中英文 最佳纠正结果
     */
    @Test
    public void test06(){
        final String hello = "hello 你好";
        final String speling = "speling 你好以毒功毒";
        Assert.assertEquals("hello 你好", WordCheckerHelper.correct(hello));
        Assert.assertEquals("spelling 你好以毒攻毒", WordCheckerHelper.correct(speling));
    }

    /**
     * 中英文 每一个词，对应的纠正结果
     */
    @Test
    public void test07(){
        final String hello = "hello 你好";
        final String speling = "speling 你好以毒功毒";
        System.out.println(WordCheckerHelper.correctMap(hello).toString());
        System.out.println(WordCheckerHelper.correctMap(speling).toString());
    }

    /**
     * 中英文 判断文本拼写是否正确,指定返回个数
     */
    @Test
    public void test08(){
        final String hello = "hello 你好";
        final String speling = "speling 你好以毒功毒";
        System.out.println(WordCheckerHelper.correctMap(hello, 2).toString());
        System.out.println(WordCheckerHelper.correctMap(speling, 2).toString());
    }
}
