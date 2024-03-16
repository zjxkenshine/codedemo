package com.kenshine.re2j;

import com.google.re2j.Pattern;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname Re2jTest
 * @Description re2j使用测试
 * @Date 2024-03-16 14:00
 * @modified By：
 * @version: 1.0$
 */
public class Re2jTest {

    /**
     * 既有前匹配也有后匹配，不合法
     */
    @Test
    public void test01(){
       // Pattern pattern=Pattern.compile("^(?!.*aaa).*(bbb)+(?!.*aaa.*)");
        // 汉字
        Pattern pattern=Pattern.compile("^[\u4e00-\u9fa5]{0,}$");
        boolean res = pattern.matches("abc");
        System.out.println(res);
        boolean res1 = pattern.matches("一二三");
        System.out.println(res1);
    }

}
