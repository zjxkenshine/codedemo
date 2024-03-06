package com.kenshine.jeromq.mode1;

import org.zeromq.ZMQ;

/**
 * @author kenshine
 * 客户端
 */
public class Request {
    public static void main(String args[]){
        ZMQ.Context context=ZMQ.context(1);     //I/O线程上下文的数量为1
        ZMQ.Socket socket=context.socket(ZMQ.REQ);         //ZMQ.REQ表示这是一个request类型的socket
        socket.connect("tcp://127.0.0.1:8888");      //连接到8888端口
        for (int i = 0; i < 10; i++) {
            long now = System.currentTimeMillis();
            String request = "hello, time is "+now;
            socket.send(request.getBytes());
            byte[] response=socket.recv();
            System.out.println("Request recv:\t"+new String(response));
        }
        socket.send("END".getBytes());
        
        //关闭
        socket.close();
        context.term();
    }
}