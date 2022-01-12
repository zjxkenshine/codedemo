package com.kenshine.basic._12_Aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/12 13:04
 * @description： AIO客户端
 * @modified By：
 * @version: $
 * AsynchronousSocketChannel 客户端
 */
public class SimpleClient {
    private AsynchronousSocketChannel client;

    public SimpleClient(String host, int port) throws IOException, InterruptedException, ExecutionException {
        this.client = AsynchronousSocketChannel.open();
        Future<?> future = client.connect(new InetSocketAddress(host, port));
        future.get();
    }

    public void write(byte b) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        byteBuffer.put(b);
        byteBuffer.flip();
        client.write(byteBuffer);
    }
}
