package com.kenshine.javaslang;

import javaslang.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname ConllectionsTest
 * @Description 集合使用
 * @Date 2024-01-11 10:26
 * @modified By：
 * @version: 1.0$
 */
public class ConllectionsTest {

    /**
     * 不可变集合，不会出现异常
     */
    @Test
    public void test01(){
        List<Integer> intList = List.of(1, 2, 3);
        assertEquals(3, intList.length());
        assertEquals(new Integer(1), intList.get(0));
        assertEquals(new Integer(2), intList.get(1));
        assertEquals(new Integer(3), intList.get(2));
    }

    /**
     * 可以实现计算
     */
    @Test
    public void test02(){
        int sum = List.of(1, 2, 3).sum().intValue();
        assertEquals(6, sum);
    }

}
