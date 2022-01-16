package com.kenshine.slice.test01;

import io.airlift.slice.Slice;
import io.airlift.slice.Slices;
import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 10:03
 * @description：
 * @modified By：
 * @version: $
 *
 * Slice使用测试
 */
public class SliceTest {

    /**
     * 存储Byte
     */
    @Test
    public void test01(){
        //分配空间,20个byte大小
        Slice slice = Slices.allocate(20);
        //在index为0的地方存一个byte 100
        slice.setByte(0, 100);
        //在index为1的地方存一个byte 2000
        //注意 byte的范围是最小值为-128，最大值为127（含)
        slice.setByte(1, 2000);
        //Gets a byte at the specified absolute index in this buffer.
        System.out.println(slice.getByte(0));//100
        //存的2000超出了byte的范围,所以一部分被抛弃了,
        System.out.println(slice.getByte(1));//-48

        //Length of this slice.
        System.out.println(slice.length());//20
    }

    //存储Int
    @Test
    public void test02() {
        //分配空间,20个byte
        Slice slice = Slices.allocate(20);
        //存储int
        slice.setInt(0, 10);
        //存储int,一个int占用4个byte的空间,存储第一个int占用了4个byte,所以这次索引从4开始
        //如果不从4开始,第一个Int的值就会被覆盖了
        slice.setInt(4, 30);
        System.out.println(slice.getInt(0));//10
        System.out.println(slice.getInt(4));//30
    }

    //存储String
    @Test
    public void test03() {
        Slice slice = Slices.allocate(20);
        //UTF-8编码,一个中文占3个byte
        //没有直接存储String的方法,要转为Bytes
        slice.setBytes(0, "测试".getBytes());
        //因为两个汉字占了6个byte,所以第二次存要从索引6开始
        slice.setBytes(6, "apple".getBytes());
        //从指定位置取出,然后还要指出取出的byte长度
        //因为取出的是byte,需要转为String打印
        System.out.println(new String(slice.getBytes(0, 6)));//测试
        System.out.println(new String(slice.getBytes(6, 5)));//apple
    }

    /**
     * toString方法
     */
    @Test
    public void test04_toString(){
        String apple = Slices.copiedBuffer("apple", UTF_8).toString(UTF_8);
        System.out.println(apple);
    }


}
