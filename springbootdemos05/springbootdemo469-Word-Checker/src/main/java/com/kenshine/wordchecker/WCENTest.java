package com.kenshine.wordchecker;

import com.github.houbb.word.checker.util.WordCheckerHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname WCENTest
 * @Description 英文检测
 * @Date 2023-11-10 8:48
 * @modified By：
 * @version: 1.0$
 */
public class WCENTest {

    /**
     * 是否拼写正确
     */
    @Test
    public void test01(){
        final String hello = "hello";
        final String speling = "speling";
        Assert.assertTrue(WordCheckerHelper.isCorrect(hello));
        Assert.assertFalse(WordCheckerHelper.isCorrect(speling));
    }


    /**
     * 返回最佳匹配结果
     */
    @Test
    public void test02(){
        final String hello = "hello";
        final String speling = "speling";
        Assert.assertEquals("hello", WordCheckerHelper.correct(hello));
        Assert.assertEquals("spelling", WordCheckerHelper.correct(speling));
    }

    /**
     * 默认纠正匹配列表
     */
    @Test
    public void test03(){
        final String word = "goox";
        List<String> stringList = WordCheckerHelper.correctList(word);
        System.out.println(stringList.toString());
    }

    /**
     * 指定纠正匹配列表大小
     */
    @Test
    public void test04(){
        final String word = "goox";
        final int limit = 2;
        List<String> stringList = WordCheckerHelper.correctList(word, limit);
        Assert.assertEquals("[good, goo]", stringList.toString());
    }
}
