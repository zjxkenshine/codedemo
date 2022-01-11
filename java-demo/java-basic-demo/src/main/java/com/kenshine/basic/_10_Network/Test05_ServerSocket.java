package com.kenshine.basic._10_Network;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 19:30
 * @description：
 * @modified By：
 * @version: $
 * Socket简单示例
 */
public class Test05_ServerSocket {

    /**
     * 客户端
     */
    @Test
    public void test01_Socket() throws IOException {
        //1.创建客户端
        Socket socket=new Socket("127.0.0.1",8888);
        //2.获取输出流
        OutputStream os=socket.getOutputStream();
        //3.写数据
        os.write("我是客户端".getBytes());
        //inputStream可读取服务端发送的数据
        //4.关闭
        socket.close();
    }

    /**
     * 服务端
     */
    @Test
    public void test02_ServerSocket() throws IOException {
        //1.创建服务器
        ServerSocket serverSocket=new ServerSocket(8888);
        //2.获取客户端对象
        Socket socket=serverSocket.accept();
        //3.读
        InputStream is=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //4.写
        OutputStream os=socket.getOutputStream();
        os.write("服务端收到".getBytes());
        //5.关闭
        socket.close();
        serverSocket.close();
    }

}
