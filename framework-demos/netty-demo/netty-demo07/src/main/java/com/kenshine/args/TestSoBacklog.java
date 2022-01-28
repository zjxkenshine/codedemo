package com.kenshine.args;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/28 18:04
 * @description：
 * @modified By：
 * @version: $
 */
public class TestSoBacklog {
    public static void main(String[] args) {
        // 设置全连接队列，大小为2
        new ServerBootstrap().option(ChannelOption.SO_BACKLOG, 2);
    }
}
