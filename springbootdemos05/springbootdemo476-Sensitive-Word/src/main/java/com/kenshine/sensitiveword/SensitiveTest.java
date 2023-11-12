package com.kenshine.sensitiveword;

import com.github.houbb.sensitive.word.api.IWordAllow;
import com.github.houbb.sensitive.word.api.IWordDeny;
import com.github.houbb.sensitive.word.api.IWordReplace;
import com.github.houbb.sensitive.word.api.IWordResult;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import com.github.houbb.sensitive.word.support.result.WordResultHandlers;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 18:25
 * @description：敏感词测试
 * @modified By：
 * @version: $
 */
public class SensitiveTest {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        final String text = "五星红旗迎风飘扬，毛主席的画像屹立在天安门前。";
        // 是否包含敏感词
        System.out.println(SensitiveWordHelper.contains(text));
        // 返回第一个敏感词
        String word = SensitiveWordHelper.findFirst(text);
        System.out.println(word);
        // WordResultHandlers.raw() 返回下标信息
        String word1 = SensitiveWordHelper.findFirst(text, WordResultHandlers.word());
        IWordResult word2 = SensitiveWordHelper.findFirst(text, WordResultHandlers.raw());
        System.out.println(word1);
        System.out.println(word2);
        // 所有敏感词
        List<String> wordList = SensitiveWordHelper.findAll(text);
        System.out.println(wordList);
        // 下标信息
        List<String> wordList1 = SensitiveWordHelper.findAll(text, WordResultHandlers.word());
        List<IWordResult> wordList2 = SensitiveWordHelper.findAll(text, WordResultHandlers.raw());
        System.out.println(wordList1);
        System.out.println(wordList2);

        // 默认替换策略
        String result = SensitiveWordHelper.replace(text);
        System.out.println(result);
        // 指定替换内容
        String result1 = SensitiveWordHelper.replace(text, '0');
        System.out.println(result1);
    }

    /**
     * 自定义替换策略
     */
    @Test
    public void test02(){
        final String text = "五星红旗迎风飘扬，毛主席的画像屹立在天安门前。";
        IWordReplace replace = new MyWordReplace();
        String result = SensitiveWordHelper.replace(text, replace);
        System.out.println(result);
    }

    /**
     * 特殊检测
     */
    @Test
    public void test03(){
        // 邮箱检测
        final String text = "楼主好人，邮箱 sensitiveword@xx.com";
        List<String> wordList = SensitiveWordHelper.findAll(text);
        System.out.println(wordList);

        // 连续数字检测
        final String text1 = "你懂得：12345678";
        // 默认检测 8 位
        List<String> wordList1 = SensitiveWordBs.newInstance().init().findAll(text1);
        // 指定数字长度 防止误杀
        List<String> wordList2 = SensitiveWordBs.newInstance()
                .numCheckLen(9)
                .init()
                .findAll(text1);
        System.out.println(wordList1);
        System.out.println(wordList2);

        // 网址检测
        final String text3 = "点击链接 www.baidu.com查看答案";
        List<String> wordList3 = SensitiveWordBs.newInstance().init().findAll(text3);
        System.out.println(wordList3);
    }

    /**
     * SensitiveWordBs 引导接口
     */
    @Test
    public void test04(){
        // 系统敏感词
        SensitiveWordBs wordBs = SensitiveWordBs.newInstance()
                .wordDeny(WordDenys.defaults())
                .wordAllow(WordAllows.defaults())
                .init();
        final String text = "五星红旗迎风飘扬，毛主席的画像屹立在天安门前。";
        System.out.println(wordBs.findAll(text));
    }

    /**
     * 自定义敏感词
     */
    @Test
    public void test05(){
        String text = "这是一个测试，我的自定义敏感词。";
        SensitiveWordBs wordBs = SensitiveWordBs.newInstance()
                .wordDeny(new MyWordDeny())
                .wordAllow(new MyWordAllow())
                .init();
        System.out.println(wordBs.findAll(text).toString());
    }

    /**
     * 链式敏感词
     */
    @Test
    public void test06(){
        String text = "这是一个测试。我的自定义敏感词。";
        IWordDeny wordDeny = WordDenys.chains(WordDenys.defaults(), new MyWordDeny());
        IWordAllow wordAllow = WordAllows.chains(WordAllows.defaults(), new MyWordAllow());
        SensitiveWordBs wordBs = SensitiveWordBs.newInstance()
                .wordDeny(wordDeny)
                .wordAllow(wordAllow)
                .init();
        System.out.println(wordBs.findAll(text).toString());
    }

}
