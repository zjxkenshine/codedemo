package com.kenshine.rpc.client;


import com.kenshine.rpc.handler.RpcResponseMessageHandler;
import com.kenshine.rpc.message.RpcRequestMessage;
import com.kenshine.rpc.protocol.MessageCodecSharable;
import com.kenshine.rpc.protocol.ProcotolFrameDecoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
public class RpcClient {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler loggingHandler = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable messageSharableCodec = new MessageCodecSharable();

        // PRC 请求消息处理器
        RpcResponseMessageHandler rpcResponseMessageHandler = new RpcResponseMessageHandler();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(group);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProcotolFrameDecoder());
                    ch.pipeline().addLast(loggingHandler);
                    ch.pipeline().addLast(messageSharableCodec);
                    ch.pipeline().addLast(rpcResponseMessageHandler);
                }
            });
            Channel channel = bootstrap.connect(new InetSocketAddress("localhost", 8080)).sync().channel();
            // 创建请求并发送
            RpcRequestMessage message = new RpcRequestMessage(1,
                    "com.kenshine.rpc.server.service.HelloService",
                    "sayHello",
                    String.class,
                    new Class[]{String.class},
                    new Object[]{"Kenshine"});

            channel.writeAndFlush(message);
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}