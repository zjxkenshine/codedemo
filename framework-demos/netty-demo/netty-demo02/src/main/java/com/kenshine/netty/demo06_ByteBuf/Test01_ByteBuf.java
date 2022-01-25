package com.kenshine.netty.demo06_ByteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

import java.nio.charset.StandardCharsets;


/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 11:57
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01_ByteBuf {

    /**
     * ByteBuf通过ByteBufAllocator选择allocator并调用对应的buffer()方法来创建的，默认使用直接内存作为ByteBuf，容量为256个字节，可以指定初始容量的大小
     * 当ByteBuf的容量无法容纳所有数据时，ByteBuf会进行扩容操作
     * 如果在handler中创建ByteBuf，建议使用ChannelHandlerContext ctx.alloc().buffer()来创建
     */
    @Test
    public void test01(){
        // 创建ByteBuf
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(16);
        ByteBufUtils.log(buffer);

        // 向buffer中写入数据
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 20; i++) {
            sb.append("a");
        }
        buffer.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8));

        // 查看写入结果
        ByteBufUtils.log(buffer);
    }
}
