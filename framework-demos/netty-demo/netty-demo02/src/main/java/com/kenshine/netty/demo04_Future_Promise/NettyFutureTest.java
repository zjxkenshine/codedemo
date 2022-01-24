package com.kenshine.netty.demo04_Future_Promise;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/24 21:21
 * @description：
 * @modified By：
 * @version: $
 *
 * Netty中的Future对象，可以通过EventLoop的sumbit()方法得到
 *
 * 可以通过Future对象的get方法，阻塞地获取返回结果
 * 也可以通过getNow方法，获取结果，若还没有结果，则返回null，该方法是非阻塞的
 * 还可以通过future.addListener方法，在Callable方法执行的线程中，异步获取返回结果
 */
public class NettyFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        // 获得 EventLoop 对象
        EventLoop eventLoop = group.next();
        Future<Integer> future = eventLoop.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 50;
            }
        });

        // 主线程中获取结果
        System.out.println(Thread.currentThread().getName() + " 获取结果");
        System.out.println("getNow " + future.getNow());
        System.out.println("get " + future.get());

        // NIO线程中异步获取结果
        future.addListener(new GenericFutureListener<Future<? super Integer>>() {
            @Override
            public void operationComplete(Future<? super Integer> future) throws Exception {
                System.out.println(Thread.currentThread().getName() + " 获取结果");
                System.out.println("getNow " + future.getNow());
            }
        });
    }
}
