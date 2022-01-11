package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:50
 * @description：
 * @modified By：
 * @version: $
 *
 */
public class Test05_Selector {

    /**
     * 1.非阻塞通信客户端
     */
    @Test
    public void test01_Client() throws IOException {
        //1.获取通道
        SocketChannel sChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));
        //2.切换非阻塞模式
        sChannel.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buf= ByteBuffer.allocate(1024);
        //4.发送数据给服务器
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.next();
            buf.put((new Date().toString()+"\n"+str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //5.关闭通道
        sChannel.close();
    }

    /**
     * 2.非阻塞通信服务端
     */
    @Test
    public void test02_Server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel =ServerSocketChannel.open();
        //2.切换非阻塞模式
        ssChannel.configureBlocking(false);
        //3.绑定连接
        ssChannel.bind(new InetSocketAddress(6666));
        //4.获取选择器
        Selector selector= Selector.open();
        //5.将通道注册到选择器上并监听(监听接收状态)
        /**ops:监听事件
         * 读:SelectionKey.OP_READ
         * 写:SelectionKey.OP_WRITE
         * 连接:SelectionKey.OP_CONNECT
         * 接收:SelectionKey.OP_ACCEPT
         */
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询式获取选择器上已经准备就绪的事件
        while(selector.select()>0) {
            //7.获取当前选择器中所有注册的选择键(已就绪监听事件)
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            while(it.hasNext()) {
                //8.获取准备"就绪"的事件
                SelectionKey sk=it.next();
                //9.判断具体是什么事件准备就绪
                if(sk.isAcceptable()) {	//接收就绪
                    //10.若接收就绪，获取客户端连接
                    SocketChannel sChannel=ssChannel.accept();
                    //11.切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //12.将该通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                }else if(sk.isReadable()) {//是否读就绪
                    //13.获取当前选择器上"读就绪"状态的通道
                    SocketChannel sChannel=(SocketChannel)sk.channel();
                    //14.读取数据
                    ByteBuffer buf=ByteBuffer.allocate(1024);

                    int len=0;
                    while((len=sChannel.read(buf))>0) {
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                //15.取消选择键SelectionKey
                it.remove();
            }
        }
    }
}
