package com.kenshine.basic._12_Aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/12 13:03
 * @description：AIO服务端
 * @modified By：
 * @version: $
 */
public class SimpleServer {

    //AIO示例 AsynchronousServerSocketChannel
    public SimpleServer(int port) throws IOException {
        final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));

        listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            public void completed(AsynchronousSocketChannel ch, Void att) {
                // 接受下一个连接
                listener.accept(null, this);
                // 处理当前连接
                handle(ch);
            }

            public void failed(Throwable exc, Void att) {}
        });

    }

    public void handle(AsynchronousSocketChannel ch) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        try {
            ch.read(byteBuffer).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        byteBuffer.flip();
        System.out.println(byteBuffer.get());
    }
}
