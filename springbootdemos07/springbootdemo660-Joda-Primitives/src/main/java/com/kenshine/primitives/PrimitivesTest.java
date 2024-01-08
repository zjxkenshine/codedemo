package com.kenshine.primitives;

import org.joda.primitives.list.impl.ArrayIntList;
import org.joda.primitives.list.impl.ImmutableArrayDoubleList;
import org.joda.primitives.listiterator.DoubleListIterator;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname PrimitivesTest
 * @Description 原始类型使用测试
 * @Date 2024-01-08 14:20
 * @modified By：
 * @version: 1.0$
 */
public class PrimitivesTest {

    /**
     * ArrayIntList
     */
    @Test
    public void test01(){
        ArrayIntList integers = new ArrayIntList();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        System.out.println(integers);
    }

    /**
     * 不可变原始类型集合
     */
    @Test
    public void test02(){
        ImmutableArrayDoubleList doubles = ImmutableArrayDoubleList.copyOf(new double[]{1.1d,1.2d,1.3d,1.4d,1.5d});
        System.out.println(doubles);
    }

}
