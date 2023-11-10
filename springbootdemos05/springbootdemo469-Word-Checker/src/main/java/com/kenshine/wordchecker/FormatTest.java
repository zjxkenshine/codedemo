package com.kenshine.wordchecker;

import com.github.houbb.word.checker.util.WordCheckerHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname FormatTest
 * @Description 格式化
 * @Date 2023-11-10 8:57
 * @modified By：
 * @version: 1.0$
 */
public class FormatTest {

    /**
     * 大小写 大写会被统一格式化为小写
     */
    @Test
    public void test01(){
        final String word = "stRing";
        Assert.assertTrue(WordCheckerHelper.isCorrect(word));
    }

    /**
     * 全角会被统一格式化为半角
     */
    @Test
    public void test02(){
        final String word = "stｒing";
        Assert.assertTrue(WordCheckerHelper.isCorrect(word));
    }

    /**
     * 自定义英文词库 resources/data/define_word_checker_en.txt
     *
     * 每一行第一列代表单词，第二列代表出现的次数，二者用逗号 , 隔开。
     * 次数越大，在纠正的时候返回优先级就越高，默认值为 1。
     * 用户自定义的词库优先级高于系统内置词库。
     */
    @Test
    public void test03(){
        final String word = "my-long-long-define-word";
        final String word2 = "my-long-long-define-word-two";
        Assert.assertTrue(WordCheckerHelper.isCorrect(word));
        Assert.assertTrue(WordCheckerHelper.isCorrect(word2));
    }

    /**
     * 自定义中文词库 resources/data/define_word_checker_zh.txt
     * 使用英文空格分隔，前面是错误，后面是正确。
     */
    @Test
    public void test04(){
        final String word = "默守成龟";
        System.out.println(WordCheckerHelper.isCorrect(word));
        System.out.println(WordCheckerHelper.correct(word));
    }

}
