package com.kenshine.demo04.demo03.server;

import com.kenshine.demo04.demo03.protocol.MessageCodecSharable;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/26 22:39
 * @description： 聊天服务器
 * @modified By：
 * @version: $
 */
@Slf4j
public class ChatServer {
    // 自定义可共享解码器
    public static final MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
    // 共用的Handler
    public static final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);

    public static void main(String[] args) throws InterruptedException {

        final NioEventLoopGroup boss = new NioEventLoopGroup();
        final NioEventLoopGroup worker = new NioEventLoopGroup();

        try {
            final ServerBootstrap bs = new ServerBootstrap();
            bs.channel(NioServerSocketChannel.class);
            bs.group(boss, worker);
            bs.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 12, 4, 0, 0));
                    ch.pipeline().addLast(LOGGING_HANDLER);
                    ch.pipeline().addLast(MESSAGE_CODEC);

                }
            });
            final ChannelFuture channelFuture = bs.bind(8081).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
