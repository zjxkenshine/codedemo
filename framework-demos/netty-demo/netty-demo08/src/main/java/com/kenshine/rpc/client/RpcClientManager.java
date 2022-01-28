package com.kenshine.rpc.client;


import com.kenshine.rpc.handler.RpcResponseMessageHandler;
import com.kenshine.rpc.message.RpcRequestMessage;
import com.kenshine.rpc.protocol.MessageCodecSharable;
import com.kenshine.rpc.protocol.ProcotolFrameDecoder;
import com.kenshine.rpc.protocol.SequenceIdGenerator;
import com.kenshine.rpc.server.service.HelloService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 客戶端改进
 */
@Slf4j
public class RpcClientManager {
    /**
     * 产生SequenceId
     */
    private static volatile Channel channel = null;
    private static final Object lock = new Object();
    public static void main(String[] args) {
        // 创建代理对象
        HelloService service = (HelloService) getProxy(HelloService.class);
        // 通过代理对象执行方法
        System.out.println(service.sayHello("Kenshine"));
        System.out.println(service.sayHello("Qin"));
    }

    /**
     * 单例模式创建Channel
     */
    public static Channel getChannel() {
        if (channel == null) {
            synchronized (lock) {
                if (channel == null) {
                    init();
                }
            }
        }
        return channel;
    }

    /**
     * 使用代理模式，帮助我们创建请求消息并发送
     */
    public static Object getProxy(Class<?> serviceClass) {
        Class<?>[] classes = new Class<?>[]{serviceClass};

        // 使用JDK代理，创建代理对象
        Object o = Proxy.newProxyInstance(serviceClass.getClassLoader(), classes, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 创建请求消息
                int id = SequenceIdGenerator.nextId();
                RpcRequestMessage message = new RpcRequestMessage(id, serviceClass.getName(),
                        method.getName(), method.getReturnType(),
                        method.getParameterTypes(),
                        args);
                // 发送消息
                getChannel().writeAndFlush(message);

                // 创建Promise，用于获取NIO线程中的返回结果，获取的过程是异步的
                DefaultPromise<Object> promise = new DefaultPromise<>(getChannel().eventLoop());
                // 将Promise放入Map中
                RpcResponseMessageHandler.PROMISES.put(id, promise);
                // 等待被放入Promise中结果
                promise.await();
                if (promise.isSuccess()) {
                    // 调用方法成功，返回方法执行结果
                    return promise.getNow();
                } else {
                    // 调用方法失败，抛出异常
                    throw new RuntimeException(promise.cause());
                }
            }
        });
        return o;
    }

    // 初始化channel
    private static void init() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        LoggingHandler loggingHandler = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable messageSharableCodec = new MessageCodecSharable();

        // PRC 请求消息处理器
        RpcResponseMessageHandler rpcResponseMessageHandler = new RpcResponseMessageHandler();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(group);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ProcotolFrameDecoder());
                ch.pipeline().addLast(loggingHandler);
                ch.pipeline().addLast(messageSharableCodec);

                ch.pipeline().addLast(rpcResponseMessageHandler);
            }
        });
        try {
            channel = bootstrap.connect(new InetSocketAddress("localhost", 8080)).sync().channel();
            // 异步关闭 group，避免Channel被阻塞
            channel.closeFuture().addListener(future -> {
                group.shutdownGracefully();
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}