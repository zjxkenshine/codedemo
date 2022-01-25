package com.kenshine.netty.demo06_ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 16:12
 * @description：
 * @modified By：
 * @version: $
 */
public class Test02_Write {
    public static void main(String[] args) {
        // 创建ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16, 20);
        ByteBufUtils.log(buffer);

        // 向buffer中写入数据
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        ByteBufUtils.log(buffer);

        //	Big Endian（大端写入），即 0x250，写入后 00 00 02 50
        buffer.writeInt(5);
        ByteBufUtils.log(buffer);

        // Little Endian（小端写入），即 0x250，写入后 50 02 00 00
        // 默认为大端写入
        buffer.writeIntLE(6);
        ByteBufUtils.log(buffer);

        // 写入long类型数据
        buffer.writeLong(7);
        ByteBufUtils.log(buffer);
    }
}
