package com.kenshine.rpc.handler;


import com.kenshine.rpc.message.RpcResponseMessage;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 泛型通配符 Promise<?> 只能 从泛型容器里获取值，不能从泛型容器中设置值
 *
 * Sharable必须保证线程安全
 */
@Slf4j
@ChannelHandler.Sharable
public class RpcResponseMessageHandler extends SimpleChannelInboundHandler<RpcResponseMessage> {

    /**
     * 用户保存每个线程客户端执行结果
     */
    public static final Map<Integer, Promise<Object>> PROMISES = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcResponseMessage msg) throws Exception {
        // 将返回结果放入对应的Promise中，并移除Map中的Promise
        Promise<Object> promise = PROMISES.remove(msg.getSequenceId());
        Object returnValue = msg.getReturnValue();
        Exception exception = msg.getExceptionValue();
        if (promise != null) {
            if (exception != null) {
                // 返回结果中有异常信息
                promise.setFailure(exception);
            } else {
                // 方法正常执行，没有异常
                promise.setSuccess(returnValue);
            }
        }
        // 拿到返回结果并打印
        log.debug("{}", msg);
    }
}
