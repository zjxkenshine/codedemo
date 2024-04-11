package com.kenshine.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author kenshine
 * 服务端启动类
 */
public class NettyTcpServerBootstrap {
    private int port;
    private SocketChannel socketChannel;

    public NettyTcpServerBootstrap(int port) throws InterruptedException {
        this.port = port;
    }

    public void start() throws InterruptedException {
        /**
         * 创建两个线程组 bossGroup 和 workerGroup
         * bossGroup 只是处理连接请求，真正的和客户端业务处理，会交给 workerGroup 完成
         *  两个都是无线循环
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //设置两个线程组
            bootstrap.group(bossGroup, workerGroup)
                    //使用NioServerSocketChannel 作为服务器的通道实现
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    //可以给 bossGroup 加个日志处理器
                    .handler(new LoggingHandler(LogLevel.INFO))
                    //给workerGroup 的 EventLoop 对应的管道设置处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            p.addLast(new ObjectEncoder());
                            p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                            p.addLast(new NettyServerHandler());
                        }
                    });

            //启动服务器并绑定一个端口并且同步生成一个 ChannelFuture 对象
            ChannelFuture cf = bootstrap.bind(port).sync();
            if (cf.isSuccess()) {
                System.out.println("socket server start---------------");
            }

            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } finally {
            //发送异常关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}