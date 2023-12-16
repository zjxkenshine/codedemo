package com.kenshine.which4j;

import org.junit.Test;
import src.org.theshoemakers.Which4J;

/**
 * @author by kenshine
 * @Classname Which4jTest
 * @Description Which4j测试
 * @Date 2023-12-16 12:31
 * @modified By：
 * @version: 1.0$
 */
public class Which4jTest {

    /**
     * 用法
     */
    @Test
    public void test01(){
        Which4J.main(new String[]{"-help"});
    }

    /**
     * which 找到类文件的位置
     */
    @Test
    public void test02(){
        String str=Which4J.which(Foo.class);
        System.out.println(str);
        String str1=Which4J.which("com.kenshine.which4j.Foo");
        System.out.println(str1);
    }

    /**
     * 命令行方式
     */
    @Test
    public void test03(){
        Which4J.main(new String[]{"-debug","com.kenshine.which4j.Foo"});
    }
}
