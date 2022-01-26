package com.kenshine.demo04.demo03.protocol;

import com.kenshine.demo04.demo03.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/26 21:55
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
public class MessageCodec extends ByteToMessageCodec<Message> {
    /**
     * 内容写入
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    public void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        // 4字节的 魔数
        out.writeBytes(new byte[]{1,2,3,4});
        // 1字节的 版本
        out.writeByte(1);
        // 1字节的 序列化方式 0-jdk,1-json
        out.writeByte(0);
        // 1字节的 指令类型
        out.writeByte(msg.getMessageType());
        // 4字节的 请求序号
        out.writeInt(msg.getSequenceId());
        // 1字节的 对其填充，只为了非消息内容 是2的整数倍
        out.writeByte(0xff);

        // 处理内容 用对象流包装字节数组 并写入
        // 访问数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 用对象流 包装
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(msg);

        byte[] bytes = bos.toByteArray();

        // 写入内容 长度
        out.writeInt(bytes.length);
        // 写入内容
        out.writeBytes(bytes);


    }

    /**
     * 内容解密读取
     * @param ctx
     * @param in
     * @param out
     * @throws Exception
     */
    @Override
    public void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 大端4字节的 魔数
        int magicNum = in.readInt();
        // 版本
        byte version = in.readByte();
        byte serializerType = in.readByte();
        byte messageType = in.readByte();
        int sequenceId = in.readInt();
        in.readByte();
        int length = in.readInt();
        final byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);

        // 处理内容
        final ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        final ObjectInputStream ois = new ObjectInputStream(bis);

        // 转成 Message类型
        Message message = (Message) ois.readObject();
        log.debug("{},{},{},{},{},{}",magicNum, version, serializerType, messageType, sequenceId, length);
        log.debug("{}", message);
        // 将message给下一个handler使用 添加到list中
        out.add(message);
    }
}
