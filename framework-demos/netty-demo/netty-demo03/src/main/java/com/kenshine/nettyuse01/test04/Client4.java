package com.kenshine.nettyuse01.test04;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 22:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Client4 {

    static final Logger log = LoggerFactory.getLogger(Client4.class);

    public static void main(String[] args) {
        send();
        System.out.println("send......finish......");
    }

    private static void send() {
        final NioEventLoopGroup worker = new NioEventLoopGroup();

        try{
            final Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(worker);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                        // channel连接建立好之后 出发 channelActive() 时间
                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            log.debug("sending...");
                            final ByteBuf buf = ctx.alloc().buffer();

                            final Random r = new Random();
                            char c = 'a';

                            for (int i = 0; i < 5; i++) {
                                // 数据以 \n 结尾
                                final StringBuilder tmpStr = getStr(c, r.nextInt(256) + 1); // 随机生成 1-257 长度的 字符串
                                c++;
                                buf.writeBytes(tmpStr.toString().getBytes());
                            }

                            ctx.writeAndFlush(buf);
                        }
                    });
                }
            });

            final ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            log.error("Client error", e);
        } finally {
            worker.shutdownGracefully();
        }
    }

    public static StringBuilder getStr(char c, int len){
        final StringBuilder s = new StringBuilder(len + 2);
        for (int i = 0; i < len; i++) {
            s.append(c);
        }

        s.append('\n');
        return s;
    }
}
