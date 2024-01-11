package com.kenshine.javaslang;

import javaslang.control.Try;
import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author by kenshine
 * @Classname TryTest
 * @Description Try 返回计算异常
 * @Date 2024-01-11 8:48
 * @modified By：
 * @version: 1.0$
 */
public class TryTest {

    /**
     * 不会因为异常中断
     */
    @Test
    public void test01(){
        Try<Integer> result = Try.of(() -> 1 / 0);
        // 无论计算是否成功，都可以在代码中的任何位置通过判断isFailure，决定下一步的处理
        assertTrue(result.isFailure());
    }

    /**
     * try默认返回值
     */
    @Test
    public void test02(){
        Try<Integer> computation = Try.of(() -> 1 / 0);
        int result = computation.getOrElse(-1);
        assertEquals(-1, result);
    }

    /**
     * 声明抛出异常
     */
    @Test(expected = ArithmeticException.class)
    public void test03(){
        Try<Integer> result = Try.of(() -> 1 / 0);
        result.getOrElseThrow((Supplier<ArithmeticException>) ArithmeticException::new);
    }

}
