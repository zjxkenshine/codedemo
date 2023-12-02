package com.kenshine.jheaps;

import org.jheaps.array.BinaryArrayAddressableHeap;
import org.jheaps.array.BinaryArrayHeap;
import org.jheaps.monotone.IntegerRadixHeap;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JheapsTest
 * @Description 使用测试
 * @Date 2023-12-02 17:11
 * @modified By：
 * @version: 1.0$
 */
public class JheapsTest {

    /**
     * BinaryArrayHeap使用测试
     */
    @Test
    public void test01(){
        BinaryArrayHeap<String> sbah=BinaryArrayHeap.heapify(new String[]{"kenshine","pig","dog","qin","lin"});
        String min=sbah.findMin();
        System.out.println(min);
        sbah.deleteMin();
        System.out.println(sbah.findMin());
    }

    /**
     * BinaryArrayAddressableHeap 二进制可寻址堆
     */
    @Test
    public void test02(){
        BinaryArrayAddressableHeap<Integer,String> baah= BinaryArrayAddressableHeap.heapify(new Integer[]{1,2,3,4,5},new String[]{"kenshine","pig","dog","qin","lin"});
        System.out.println(baah.findMin().getKey()+":"+baah.findMin().getValue());
        baah.deleteMin();
        System.out.println(baah.findMin().getKey()+":"+baah.findMin().getValue());
    }

    /**
     * IntegerRadixHeap Integer基数堆
     */
    @Test
    public void test03(){
        // 可存储的最小值与最大值
        IntegerRadixHeap integerRadixHeap = new IntegerRadixHeap(1,200);
        integerRadixHeap.insert(51);
        integerRadixHeap.insert(22);
        integerRadixHeap.insert(93);
        integerRadixHeap.insert(99);
        integerRadixHeap.insert(71);
        //integerRadixHeap.insert(1000);
        System.out.println(integerRadixHeap.findMin());
    }

    /**
     * 其余堆参照源码
     */
}
