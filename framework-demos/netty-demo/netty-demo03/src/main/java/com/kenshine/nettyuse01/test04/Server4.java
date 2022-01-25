package com.kenshine.nettyuse01.test04;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 22:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Server4 {
    static final Logger log = LoggerFactory.getLogger(Server4.class);

    void start(){
        final NioEventLoopGroup boss = new NioEventLoopGroup();
        final NioEventLoopGroup worker = new NioEventLoopGroup();

        try{
            final ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.channel(NioServerSocketChannel.class);

            // 调整系统的接收缓冲区 设置字节 【使 发生半包】
            // serverBootstrap.option(ChannelOption.SO_RCVBUF, 10);
            // 调整netty的接受缓冲区 (byteBuf)  【这里最小就是16，因为他是16的整数倍】 【注意还要调整 客户端每次发送字节 > 16个】
            // serverBootstrap.childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(16,16,16));

            serverBootstrap.group(boss, worker);
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {

                    /*####                 行解码器                 ###*/
                    // 通过行解码器对粘包数据进行拆分，以 \n 为分隔符
                    // 需要指定最大长度
//                    ch.pipeline().addLast(new LineBasedFrameDecoder(1024));

                    /*####            自定义定界符 帧解码器           ###*/
                    final ByteBuf buf = Unpooled.wrappedBuffer(new byte[]{'\r','\n'});// 客户端分隔符必须 "\r\n"
                    // 通过行解码器对粘包数据进行拆分，以 '\r','\n' 为分隔符
                    ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,buf)); // 超出1024报错

                    ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                }
            });

            final ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
            channelFuture.channel().closeFuture().sync();

        }catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new Server4().start();
    }
}
