package com.kenshine.netty.demo06_ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 19:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Test04_Slice {
    public static void main(String[] args) {
        // 创建ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16, 20);

        // 向buffer中写入数据
        buffer.writeBytes(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        // 将buffer分成两部分
        ByteBuf slice1 = buffer.slice(0, 5);
        ByteBuf slice2 = buffer.slice(5, 5);

        // 需要让分片的buffer引用计数加一
        // 避免原Buffer释放导致分片buffer无法使用
        slice1.retain();
        slice2.retain();

        ByteBufUtils.log(slice1);
        ByteBufUtils.log(slice2);

        // 更改原始buffer中的值
        System.out.println("===========修改原buffer中的值===========");
        //将索引0的位置设置为5
        buffer.setByte(0,5);

        System.out.println("===========打印slice1===========");
        ByteBufUtils.log(slice1);
    }
}
