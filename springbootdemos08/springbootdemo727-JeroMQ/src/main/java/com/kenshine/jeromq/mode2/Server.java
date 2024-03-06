package com.kenshine.jeromq.mode2;

import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;

/**
 * @author kenshine
 * 服务端
 * 发布订阅模式
 */
public class Server {
    public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket publisher = context.createSocket(ZMQ.PUB); //publish类型
            publisher.bind("tcp://*:5555");
 
            Random random = new Random();
            while (true) {
                String update;
                //随机将update赋值为Time: 或Order: 开头的值
                if (random.nextInt(10)<=5)
                    update = "Time: "+System.currentTimeMillis();
                else
                    update = "Order: "+System.currentTimeMillis();
                publisher.send(update); //发送
                System.out.println("SEND:["+update+"]");
            }
        }
    }
}