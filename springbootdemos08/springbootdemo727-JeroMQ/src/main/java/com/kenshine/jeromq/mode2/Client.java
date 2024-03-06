package com.kenshine.jeromq.mode2;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;

/**
 * @author kenshine
 * 客户端
 * 发布订阅模式
 */
public class Client {
    public static void main(String args[]){
        try(ZContext context= new ZContext()) {
            ZMQ.Socket subscriber = context.createSocket(ZMQ.SUB); //subscribe类型
            subscriber.connect("tcp://localhost:5555");

            subscriber.subscribe("Time:".getBytes()); //只订阅Time: 开头的信息

            for (int i = 0; i < 1000; i++) {
                System.out.println(subscriber.recvStr()); //recvStr直接返回String，内部调用了recv，将byte数组转化为String
            }
        }
    }
}