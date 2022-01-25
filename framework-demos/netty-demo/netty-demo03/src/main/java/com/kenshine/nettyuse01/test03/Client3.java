package com.kenshine.nettyuse01.test03;

import com.kenshine.nettyuse01.test01.StudyClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/25 21:34
 * @description： 客户端
 * @modified By：
 * @version: $
 */
public class Client3 {
    static final Logger log = LoggerFactory.getLogger(StudyClient.class);


    public static void main(String[] args) {
        send();
        System.out.println("finish");
    }

    public static void send(){
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.group(worker);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    log.debug("connected...");
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                        //定长解码器
                        // channel连接建立好之后 出发 channelActive() 时间
                        @Override
                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                            log.debug("sending...");
                            final Random r = new Random();
                            final ByteBuf buf = ctx.alloc().buffer();


                            for (int i = 0; i < 10; i++) {
                                final int idx = r.nextInt(10) + i*10;
                                buf.writeBytes(new byte[]{1,2,3,4,5,6,7,8,9,10});
                                buf.setByte(idx,'a');
                            }
                            ctx.writeAndFlush(buf);
                        }
                    });
                }
            });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8080).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            log.error("client error", e);
        } finally {
            worker.shutdownGracefully();
        }
    }



}
