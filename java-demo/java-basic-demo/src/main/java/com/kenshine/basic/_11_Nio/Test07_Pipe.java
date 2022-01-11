package com.kenshine.basic._11_Nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 22:06
 * @description：
 * @modified By：
 * @version: $
 */
public class Test07_Pipe {

    public static void main(String[] args) throws IOException {
        //1.获取管道
        Pipe pipe= Pipe.open();

        //2.将缓冲区中的数据写入管道 SinkChannel
        ByteBuffer buf= ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel=pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //3.读取缓冲区的数据 SourceChannel 可以在另一个线程中读取
        Pipe.SourceChannel sourceChannel=pipe.source();
        buf.flip();
        int len=sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));

        sourceChannel.close();
        sinkChannel.close();
    }

}
