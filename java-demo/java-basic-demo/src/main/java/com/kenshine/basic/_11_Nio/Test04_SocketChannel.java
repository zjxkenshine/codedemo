package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:38
 * @description：
 * @modified By：
 * @version: $
 * 1.阻塞式通信客户端
 * 2.阻塞式通信服务端
 *
 * 没有用到Selector
 */
public class Test04_SocketChannel {

    /**
     * 1. 客户端代码 一般写法
     */
    @Test
    public void test01_SocketChannel() throws IOException {
        //1.获取通道
        SocketChannel sChannel =SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        //2.分配指定大小的缓冲区
        ByteBuffer buf= ByteBuffer.allocate(1024);

        //3.读取本地文件，并发送到服务器端
        while(inChannel.read(buf)!=-1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4.关闭通道
        inChannel.close();
        sChannel.close();
    }

    /**
     * 2. 服务端代码 一般写法
     */
    @Test
    public void test02_ServerSocketChannel() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel=ServerSocketChannel.open();
        FileChannel outChannel=FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(6666));

        //3.获取客户端连接的通道
        SocketChannel sChannel=ssChannel.accept();

        //4.分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //5.接收客户端的参数，并保存到本地
        while(sChannel.read(buf)!=-1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //6.关闭通道
        sChannel.close();
        outChannel.close();
        ssChannel.close();
    }

}
