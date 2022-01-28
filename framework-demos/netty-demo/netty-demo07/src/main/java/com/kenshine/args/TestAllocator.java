package com.kenshine.args;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.ChannelOption;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 18:11
 * @description：
 * @modified By：
 * @version: $
 */
public class TestAllocator {
    public static void main(String[] args) {
        // 选择ALLOCATOR参数，设置SocketChannel中分配的ByteBuf类型
        // 第二个参数需要传入一个ByteBufAllocator，用于指定生成的 ByteBuf 的类型
        new ServerBootstrap().childOption(ChannelOption.ALLOCATOR, new PooledByteBufAllocator());

        //ByteBufAllocator类型
        // true表示使用直接内存 池化并使用直接内存
        new PooledByteBufAllocator(true);
        // false表示使用堆内存 池化并使用堆内存
        new PooledByteBufAllocator(false);
        // ture表示使用直接内存 非池化并使用直接内存
        new UnpooledByteBufAllocator(true);
        // false表示使用堆内存  非池化并使用堆内存
        new UnpooledByteBufAllocator(false);
    }
}
