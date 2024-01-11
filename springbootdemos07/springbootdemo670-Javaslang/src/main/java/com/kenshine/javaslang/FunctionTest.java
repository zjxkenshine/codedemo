package com.kenshine.javaslang;

import javaslang.Function0;
import javaslang.Function1;
import javaslang.Function2;
import javaslang.Function5;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname FunctionTest
 * @Description 函数式编程
 * @Date 2024-01-11 10:22
 * @modified By：
 * @version: 1.0$
 */
public class FunctionTest {

    /**
     * 一个参数
     */
    @Test
    public void test01(){
        Function1<Integer, Integer> square = (num) -> num * num;
        int result = square.apply(2);
        assertEquals(4, result);
    }

    /**
     * 两个参数
     */
    @Test
    public void test02(){
        Function2<Integer, Integer, Integer> sum =
                (num1, num2) -> num1 + num2;
        int result = sum.apply(5, 7);
        assertEquals(12, result);
    }

    /**
     * Consumer
     */
    @Test
    public void test03(){
        Function0<String> getClazzName = () -> this.getClass().getName();
        String clazzName = getClazzName.apply();
        assertEquals("com.baeldung.javaslang.JavaSlangTest", clazzName);
    }

    /**
     * 5个参数函数
     */
    @Test
    public void test04(){
        Function5<String, String, String, String, String, String> concat =
                (a, b, c, d, e) -> a + b + c + d + e;
        String finalString = concat.apply(
                "Hello ", "world", "! ", "Learn ", "Javaslang");

        assertEquals("Hello world! Learn Javaslang", finalString);
    }

    /**
     * 静态工厂
     */
    @Test
    public void test05(){
        Function2<Integer, Integer, Integer> sum = Function2.of(Integer::sum);
        int summed = sum.apply(5, 6);
        assertEquals(11, summed);
    }
}
