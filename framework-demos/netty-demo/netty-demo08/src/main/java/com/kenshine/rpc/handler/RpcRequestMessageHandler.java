package com.kenshine.rpc.handler;


import com.kenshine.rpc.message.RpcRequestMessage;
import com.kenshine.rpc.message.RpcResponseMessage;
import com.kenshine.rpc.server.service.HelloService;
import com.kenshine.rpc.server.service.ServiceFactory;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
@ChannelHandler.Sharable
public class RpcRequestMessageHandler extends SimpleChannelInboundHandler<RpcRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcRequestMessage rpcMessage) {
        RpcResponseMessage rpcResponseMessage = new RpcResponseMessage();
        try {
            // 设置返回值的属性
            rpcResponseMessage.setSequenceId(rpcMessage.getSequenceId());
            // 返回一个实例
            HelloService service = (HelloService) ServiceFactory.getInstance(Class.forName(rpcMessage.getInterfaceName()));

            // 通过反射调用方法，并获取返回值
            Method method = service.getClass().getMethod(rpcMessage.getMethodName(), rpcMessage.getParameterTypes());
            // 获得返回值
            Object invoke = method.invoke(service, rpcMessage.getParameterValue());
            // 设置返回值
            rpcResponseMessage.setReturnValue(invoke);
        } catch (Exception e) {
            e.printStackTrace();
            // 设置异常
            rpcResponseMessage.setExceptionValue(e);
        }
        ctx.writeAndFlush(rpcResponseMessage);
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final RpcRequestMessage requestMsg = new RpcRequestMessage(
                        1,
                "com.kenshine.rpc.server.service.HelloService",
                "sayHello",
                String.class,
                // 方法参数类型
                new Class[]{String.class},
                // 参数值
                new Object[]{"helloworld!"}
        );
        // 上面对象里 获取【接口类】全限定名
        final Class<?> interfaceClazz = Class.forName(requestMsg.getInterfaceName());
        // 根据接口类 获取 【接口实现类】
        final HelloService service = (HelloService) ServiceFactory.getService(interfaceClazz);
        // 根据 方法名和参数类型 确定 【具体方法】
        final Method method = service.getClass().getMethod(requestMsg.getMethodName(), requestMsg.getParameterTypes());
        // 根据 具体方法 使用代理 【执行方法】
        final Object invoke = method.invoke(service, requestMsg.getParameterValue());
        System.out.println(invoke);
    }

}