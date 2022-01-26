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
 * @date ：Created in 2022/1/26 22:27
 * @description：
 * @modified By：
 * @version: $
 * 半包测试
 */
public class TestMessageCodec02 {

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

        // 半包测试
        final ByteBuf s1 = byteBuf.slice(0, 100);
        final ByteBuf s2 = byteBuf.slice(100, byteBuf.readableBytes() - 100);

        // 【引用计数 + 1】 才能 调用两次 writeInbound() 保证不会释放内容
        s1.retain();               // retain + 1 = 2
        channel.writeInbound(s1);  // release 1
        channel.writeInbound(s2);  // release 0

    }
}
