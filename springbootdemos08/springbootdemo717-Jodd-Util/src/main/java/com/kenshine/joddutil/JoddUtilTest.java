package com.kenshine.joddutil;

import jodd.util.InExRules;
import jodd.util.StringUtil;
import jodd.util.Wildcard;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JoddUtilTest
 * @Description StringUtil使用测试
 * @Date 2024-03-01 8:11
 * @modified By：
 * @version: 1.0$
 */
public class JoddUtilTest {

    /**
     * StringUtil使用
     */
    @Test
    public void test01(){
        // replace 替换
        String s=StringUtil.replace("kenshine","e","a");
        Assert.assertEquals("kanshina",s);
        // remove 移除
        String s1=StringUtil.remove("kenshine","e");
        Assert.assertEquals("knshin",s1);
        // 空字符串判断
        Assert.assertTrue(StringUtil.isEmpty(""));;
        Assert.assertTrue(StringUtil.isBlank(null));
        // 安全的equals
        Assert.assertTrue(StringUtil.equals("",""));
        // capitalize 首字母大写
        Assert.assertEquals("KenshinE",StringUtil.capitalize("kenshinE"));
        // split 拆分
        Arrays.stream(StringUtil.split("a,b,c,d,e", ",")).forEach(System.out::println);
        System.out.println("-------");
        // IndexOf 定位
        Arrays.stream(StringUtil.indexOf("kenshine", "s")).forEach(System.out::println);
        // 其他方法 trim删除空字符 Strip删除前后字符 crop替换空字符串为null cut剪裁
    }

    /**
     * InExRules 规则匹配，包含黑白名单模式
     * - 黑：指定排除，否则包含
     * - 白：指定包含，否则排除
     */
    @Test
    public void test02(){
        InExRules<String,String> inExRules = InExRules.whitelist();

        inExRules.include("shelf.book.*");
        inExRules.exclude("shelf.book.page.1");

        Boolean b1=inExRules.match("shelf.book.page.1");
        Boolean b2=inExRules.match("shelf.book");
        Boolean b3=inExRules.match("shelf.book.page.34");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }

    /**
     * Wildcard ？与*通配符匹配
     */
    @Test
    public void test03(){
        Assert.assertTrue(Wildcard.match("CfgOptions.class", "*C*g*cl*"));
        Assert.assertTrue(Wildcard.match("CfgOptions.class", "*g*c**s"));
        Assert.assertTrue(Wildcard.match("CfgOptions.class", "??gOpti*c?ass"));
        Assert.assertTrue(Wildcard.match("CfgOpti*class", "*gOpti\\*class"));
        Assert.assertTrue(Wildcard.match("CfgOptions.class", "C*ti*c?a?*"));
        // 匹配路径
        Assert.assertTrue(Wildcard.matchPath("/foo/soo/doo/boo", "/**/bo*"));
        Assert.assertTrue(Wildcard.matchPath("/foo/one/two/three/boo", "**/t?o/**"));
    }

}
