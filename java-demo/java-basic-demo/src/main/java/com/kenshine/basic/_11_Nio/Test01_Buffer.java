package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:10
 * @description：
 * @modified By：
 * @version: $
 * 核心方法
 *    - `allocate(1024)`：类方法，创建指定大小的缓冲区
 *    - `put()`：存入数据到缓冲区中
 *    - `get()`：获取缓冲区中的数据
 *    - `flip()`：读写切换
 *    - `limit()`：缓冲区可以操作的数据区域(大小)
 *    - `rewind()`：将position重置，可以重新进行读写
 *    - `clear()`：清空缓冲区,缓冲区数据仍然存在，但是不可读取，被遗忘
 *    - `reset()`：重置，配合mark方法
 */
public class Test01_Buffer {

    /**
     * 1.基本使用
     */
    @Test
    public void test01(){
        String str="666666";
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf= ByteBuffer.allocate(1024);
        //2.利用put存入数据到缓冲区中
        buf.put(str.getBytes());
        //3.切换读取数据模式
        buf.flip();
        //4.利用get读取数据:
        byte[] dst=new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        //5.rewind方法:重读
        buf.rewind();
        //6.clear():清空缓冲区,缓冲区数据仍然存在，但是不可读取，被遗忘
        buf.clear();
    }

    /**
     * Mark&Reset方法的使用
     */
    @Test
    public void test02(){
        String str="abcde";
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] dst=new byte[buf.limit()];
        //获取指定范围内的字节，获取两个字节
        buf.get(dst,0,2);
        //标记当前positon的位置 2
        buf.mark();
        //在获取两个字节 position=4
        buf.get(dst,2,2);
        //重置position为mark位置 2
        buf.reset();
        System.out.println(buf.position());	//结果为2
        //缓冲区中剩余可操作字节
        System.out.println(buf.remaining());//结果为3
    }
}
