package com.kenshine.basic._10_Network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 19:36
 * @description：
 * @modified By：
 * @version: $
 *
 * 类DatagramSocket和DatagramPacket实现了基于UDP协议网络程序。
 * UDP数据报通过数据报套接字DatagramSocket发送和接收，系统不保证
 * UDP数据报不一定能够安全送到目的地，也不能确定什么时候可以抵达。
 * DatagramPacket对象封装了UDP数据报，在数据报中包含了发送端的IP
 * 地址和端口号以及接收端的IP地址和端口号。
 * UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方的连接。如同发快递包裹一样
 */
public class Test06_DatagramSocket {

    /**
     * 发送方
     */
    @Test
    public void test01_Sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String message = "这是UDP信息";
        byte[] data = message.getBytes();
        InetAddress ip = InetAddress.getLocalHost();
        //创建数据包
        DatagramPacket packet = new DatagramPacket(data,data.length,ip,9090);
        //发送数据包
        socket.send(packet);
        socket.close();
    }

    /**
     * 接收方
     */
    @Test
    public void test02_Receive() throws IOException {
        DatagramSocket socket=new DatagramSocket(9090);
        byte[] buffer=new byte[100];
        DatagramPacket packet=new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();
    }
}
