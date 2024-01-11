package com.kenshine.javaslang;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.Tuple3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname TupleTest
 * @Description Tuple元组
 * @Date 2024-01-11 8:46
 * @modified By：
 * @version: 1.0$
 */
public class TupleTest {

    /**
     * 二元组Tuple2
     */
    @Test
    public void test01(){
        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        String element1 = java8._1;
        int element2 = java8._2();

        assertEquals("Java", element1);
        assertEquals(8, element2);
    }

    /**
     * 三元组Tuple3
     */
    @Test
    public void test02(){
        // 存放类型必须与定义顺序相同
        Tuple3<String, Integer, Double> java8 = Tuple.of("Java", 8, 1.8);
        String element1 = java8._1;
        int element2 = java8._2();
        double element3 = java8._3();

        assertEquals("Java", element1);
        assertEquals(8, element2);
        assertEquals(1.8, element3, 0.1);
    }

}
