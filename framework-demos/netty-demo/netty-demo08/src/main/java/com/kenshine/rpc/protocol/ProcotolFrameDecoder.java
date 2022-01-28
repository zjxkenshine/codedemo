package com.kenshine.rpc.protocol;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 自定义协议的编解码器 LengthFieldBasedFrameDecoder 处理粘包半包
 * 防止多次使用出错进行的封装
 */
public class ProcotolFrameDecoder extends LengthFieldBasedFrameDecoder {

    public ProcotolFrameDecoder() {
        this(1024, 12, 4, 0, 0);
    }

    public ProcotolFrameDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength, int lengthAdjustment, int initialBytesToStrip) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip);
    }
}
