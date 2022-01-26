package com.kenshine.demo04.demo03;

import com.kenshine.demo04.demo03.message.LoginRequestMessage;
import com.kenshine.demo04.demo03.protocol.MessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/26 22:11
 * @description：
 * @modified By：
 * @version: $
 * 测试，最简版本
 */
public class TestMessageCodec {

    public static void main(String[] args) throws Exception {
        EmbeddedChannel channel = new EmbeddedChannel();
        // 添加帧解码器，避免粘包半包问题
        channel.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 12, 4, 0, 0));
        channel.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
        channel.pipeline().addLast(new MessageCodec());
        LoginRequestMessage user = new LoginRequestMessage("kenshine", "123","kenshine");

        // 测试编码与解码
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        //encode
        new MessageCodec().encode(null, user, byteBuf);
        //入站
        channel.writeInbound(byteBuf);
    }
}
