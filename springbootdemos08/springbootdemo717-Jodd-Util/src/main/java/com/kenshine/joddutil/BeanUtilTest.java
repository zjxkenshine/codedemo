package com.kenshine.joddutil;

import jodd.bean.BeanUtil;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname BeanUtilTest
 * @Description BeanUtil使用
 * @Date 2024-03-01 9:02
 * @modified By：
 * @version: 1.0$
 */
public class BeanUtilTest {


    /**
     * BeanUtil定义
     */
    @Test
    public void test01(){
        Foo foo = new Foo();
        BeanUtil.pojo.setProperty(foo, "readwrite", "data");
        BeanUtil.pojo.getProperty(foo, "readwrite");
        BeanUtil.declared.setProperty(foo, "readonly", "data");
        System.out.println(foo);
    }
}
