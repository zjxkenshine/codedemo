package com.kenshine.sparsebitset;

import com.zaxxer.sparsebits.SparseBitSet;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname SparseBitSetTest
 * @Description SparseBitSet使用测试
 * @Date 2023-12-22 21:32
 * @modified By：
 * @version: 1.0$
 */
public class SparseBitSetTest {

    /**
     * previousSetBit 返回最近的为true的索引
     * 找不到返回-1
     */
    @Test
    public void test01(){
        SparseBitSet set = new SparseBitSet();
        set.set(4);
        set.set(8);
        set.set(13);
        set.set(25);
        set.set(268);
        // 返回最近的为true的索引对应的值
        final int ret = set.previousSetBit(22);
        System.out.println(ret);
    }

    /**
     *  初始化为0
     */
    @Test
    public void test02(){
        SparseBitSet bitset = new SparseBitSet(0);
        int i = bitset.previousSetBit(0);
        int i1=bitset.nextClearBit(0);
        System.out.println(i);
        System.out.println(i1);
    }

    /**
     * previousClearBit 返回在指定的起始索引上或之前出现的设置为false的最近位的索引
     */
    @Test
    public void test03(){
        SparseBitSet set = new SparseBitSet();
        set.set(1);
        set.set(64);
        System.out.println(set.previousClearBit(65));
        // 将指定索引处的位设置为false
        set.clear(0);
        set.set(1);
        System.out.println(set.previousClearBit(65));
    }
}
