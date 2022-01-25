package com.kenshine.nettyuse01.test03;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 21:33
 * @description： 服务器端
 * @modified By：
 * @version: $
 *
 *  * 建议：找到所有可能的消息 以最长的消息 来定长
 *  * 1. 譬如固定长 3
 *  * 2. 进来数据只有2 暂不把消息传给下一个handler，则等拼成3后发送
 *  * 3. 进来数据超过3，就把长度3先发送下一个handler，多余消息先保留
 */
public class Server3 {
    static final Logger log = LoggerFactory.getLogger(Server3.class);
    void start() {
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.group(boss, worker);
            // 调整channel的容量 会出现半包现象
            //serverBootstrap.option(ChannelOption.SO_RCVBUF, 10);

            // 调整netty的接受缓冲区 (byteBuf)  【这里最小就是16，因为他是16的整数倍】 【注意还要调整 客户端每次发送字节 > 16个】
            serverBootstrap.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(16,16,16));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {

                    /*定长解码器  【注意放 流水线前面】*/
                    ch.pipeline().addLast(new FixedLengthFrameDecoder(10)); // 每次定长10


                    ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            // 连接建立时会执行该方法
                            log.debug("connected {}", ctx.channel());
                            super.channelActive(ctx);
                        }

                        @Override
                        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                            // 连接断开时会执行该方法
                            log.debug("disconnect {}", ctx.channel());
                            super.channelInactive(ctx);
                        }
                    });
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8080);
            log.debug("{} binding...", channelFuture.channel());
            channelFuture.sync();
            log.debug("{} bound...", channelFuture.channel());
            // 关闭channel
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
            log.debug("stopped");
        }
    }

    public static void main(String[] args) {
        new Server3().start();
    }
}
