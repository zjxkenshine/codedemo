package com.kenshine.javaslang;

import javaslang.Lazy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname LazyTest
 * @Description 惰性求值
 * @Date 2024-01-11 10:41
 * @modified By：
 * @version: 1.0$
 */
public class LazyTest {

    /**
     * 惰性执行
     */
    @Test
    public void test01(){
        Lazy<Double> lazy = Lazy.of(Math::random);
        // 未执行
        assertFalse(lazy.isEvaluated());
        double val1 = lazy.get();
        // 已执行
        assertTrue(lazy.isEvaluated());
        double val2 = lazy.get();
        assertEquals(val1, val2, 0.1);
    }
}
