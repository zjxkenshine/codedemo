package com.kenshine.basic._11_Nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/11 21:59
 * @description： DatagramChannel udp
 * @modified By：
 * @version: $
 */
public class Test06_DatagramChannel {

    /**
     * 1.UDP客户端
     */
    @Test
    public void test01_Client() throws IOException {
        DatagramChannel dc=DatagramChannel.open();
        dc.configureBlocking(false);
        ByteBuffer buf= ByteBuffer.allocate(1024);
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            String str=scan.next();
            buf.put((new Date().toString()+":\n"+str).getBytes());
            buf.flip();
            dc.send(buf, new InetSocketAddress("127.0.0.1",6666));
            buf.clear();
        }
        dc.close();
    }

    /**
     * 2.UDP 服务端
     */
    @Test
    public void test02_Server() throws IOException {
        DatagramChannel dc=DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(6666));
        Selector selector= Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while(selector.select()>0) {
            Iterator<SelectionKey> it=selector.selectedKeys().iterator();
            while(it.hasNext()) {
                SelectionKey sk=it.next();
                if(sk.isReadable()) {	//udp无连接，没有accept
                    ByteBuffer buf=ByteBuffer.allocate(1024);
                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(),0,buf.limit()));
                    buf.clear();
                }
            }
            it.remove();
        }
    }

}
