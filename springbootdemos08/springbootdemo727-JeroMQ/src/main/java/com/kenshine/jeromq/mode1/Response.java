package com.kenshine.jeromq.mode1;

import org.zeromq.ZMQ;

/**
 * @author kenshine
 * 服务端
 */
public class Response {
    public static void main(String args[]){
        ZMQ.Context context=ZMQ.context(1);     //I/O线程上下文的数量为1
        ZMQ.Socket socket=context.socket(ZMQ.REP);         //ZMQ.REP表示这是一个reponse类型的socket
        socket.bind("tcp://*:8888");                 //绑定到8888端口
        while (true){
            byte[] request = socket.recv();
            if (new String(request).equals("END")) {
                break;
            }
            System.out.println("Response recv:\t"+new String(request));
            String response="I got it";
            socket.send(response.getBytes());
        }
        //关闭
        socket.close();
        context.term();
    }
}