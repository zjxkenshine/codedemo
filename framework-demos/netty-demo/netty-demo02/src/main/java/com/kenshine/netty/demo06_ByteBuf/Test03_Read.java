package com.kenshine.netty.demo06_ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 17:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03_Read {

    public static void main(String[] args) {
        // 创建ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16, 20);

        // 向buffer中写入数据
        buffer.writeBytes(new byte[]{1, 2, 3, 4});
        buffer.writeInt(5);

        // 读取4个字节
        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        System.out.println(buffer.readByte());
        ByteBufUtils.log(buffer);

        // 通过mark与reset实现重复读取
        buffer.markReaderIndex();
        System.out.println(buffer.readInt());
        ByteBufUtils.log(buffer);

        // 恢复到mark标记处
        buffer.resetReaderIndex();
        System.out.println(buffer.readInt());
        buffer.resetReaderIndex();
        ByteBufUtils.log(buffer);
    }
}
