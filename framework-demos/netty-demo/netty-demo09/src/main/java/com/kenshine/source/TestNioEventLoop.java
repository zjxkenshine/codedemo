package com.kenshine.source;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/29 20:08
 * @description：EventLoop启动测试
 * @modified By：
 * @version: $
 */
public class TestNioEventLoop {
    public static void main(String[] args) {
        EventLoop eventLoop = new NioEventLoopGroup().next();
        // 使用NioEventLoop执行任务
        eventLoop.execute(()->{
            System.out.println("hello");
        });
    }
}
