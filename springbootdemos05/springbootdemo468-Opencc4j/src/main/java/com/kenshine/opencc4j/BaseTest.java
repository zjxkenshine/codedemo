package com.kenshine.opencc4j;

import com.github.houbb.opencc4j.util.ZhConverterUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname BaseTest
 * @Description ZhConverterUtil
 * @Date 2023-11-09 12:08
 * @modified By：
 * @version: 1.0$
 */
public class BaseTest {

    /**
     * 简繁体转换
     */
    @Test
    public void test01(){
        String original = "生命不息，奮鬥不止";
        String result = ZhConverterUtil.toSimple(original);
        System.out.println(result);
        String result1 = ZhConverterUtil.toTraditional(result);
        System.out.println(result1);
    }

    /**
     * 是否为简体
     */
    @Test
    public void test02(){
        Assert.assertTrue(ZhConverterUtil.isSimple('奋'));
        Assert.assertTrue(ZhConverterUtil.isSimple("奋"));
        Assert.assertTrue(ZhConverterUtil.isSimple("奋斗"));
        Assert.assertFalse(ZhConverterUtil.isSimple('奮'));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮"));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮鬥"));
        Assert.assertFalse(ZhConverterUtil.isSimple("奮斗"));
        Assert.assertFalse(ZhConverterUtil.isSimple("beef"));
    }

    /**
     * 是否包含简体
     */
    @Test
    public void test03(){
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋"));
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗"));
        Assert.assertTrue(ZhConverterUtil.containsSimple("奋斗2023"));
        Assert.assertFalse(ZhConverterUtil.containsSimple("編"));
        Assert.assertFalse(ZhConverterUtil.containsSimple("編號"));
    }

    /**
     * 是否为繁体
     */
    @Test
    public void test04(){
        Assert.assertTrue(ZhConverterUtil.isTraditional('編'));
        Assert.assertTrue(ZhConverterUtil.isTraditional("編"));
        Assert.assertTrue(ZhConverterUtil.isTraditional("編號"));
        Assert.assertFalse(ZhConverterUtil.isTraditional('编'));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编"));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编号"));
        Assert.assertFalse(ZhConverterUtil.isTraditional("编號"));
    }

    /**
     * 是否包含繁体
     */
    @Test
    public void test05(){
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編"));
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編號"));
        Assert.assertTrue(ZhConverterUtil.containsTraditional("編號2023"));
        Assert.assertFalse(ZhConverterUtil.containsTraditional("号"));
        Assert.assertFalse(ZhConverterUtil.containsTraditional("编号"));
    }

    /**
     * 分词并返回简体
     */
    @Test
    public void test06(){
        final String original = "生命不息奋斗不止";
        final List<String> resultList = ZhConverterUtil.simpleList(original);
        System.out.println(resultList);
    }

    /**
     * 分词并返回繁体
     */
    @Test
    public void test07(){
        final String original = "生命不息奮鬥不止";
        final List<String> resultList = ZhConverterUtil.simpleList(original);
        System.out.println(resultList);
    }

    /**
     * 汉字对应的简繁体
     */
    @Test
    public void test08(){
        // 繁体
        Assert.assertEquals("[幹, 乾, 干]", ZhConverterUtil.toTraditional('干').toString());
        Assert.assertEquals("[發, 髮]", ZhConverterUtil.toTraditional('发').toString());
        // 简体
        Assert.assertEquals("[测]", ZhConverterUtil.toSimple('測').toString());
    }

    /**
     * 中文工具
     */
    @Test
    public void test09(){
        // 是否中文
        Assert.assertTrue(ZhConverterUtil.isChinese("你"));
        Assert.assertTrue(ZhConverterUtil.isChinese("你好"));
        Assert.assertTrue(ZhConverterUtil.isChinese('你'));
        Assert.assertFalse(ZhConverterUtil.isChinese("你0"));
        // 包含中文
        Assert.assertTrue(ZhConverterUtil.containsChinese("你"));
        Assert.assertTrue(ZhConverterUtil.containsChinese("你好"));
        Assert.assertTrue(ZhConverterUtil.containsChinese("你0"));
        Assert.assertFalse(ZhConverterUtil.containsChinese("10"));
    }



}
