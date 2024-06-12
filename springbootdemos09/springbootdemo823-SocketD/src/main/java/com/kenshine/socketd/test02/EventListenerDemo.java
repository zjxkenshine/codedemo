package com.kenshine.socketd.test02;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.EventListener;

/**
 * EventListener 事件监听器
 */
public class EventListenerDemo{
    public static void main(String[] args) throws Throwable {
        //::启动服务端
        SocketD.createServer("sd:tcp")
                .config(c -> c.port(8602))
                .listen(new EventListener().doOnMessage((s, m)->{
                    System.out.println(m);
                    s.send("/demo", new StringEntity("Me too!"));
                }).doOn("/order", (s,m)->{ //根据消息事件路由
                    System.out.println(m); //在 onMessage 时已打印一次，这算第二次打印
                }).doOn("/user", (s,m)->{ //根据消息事件路由
                    System.out.println(m); //在 onMessage 时已打印一次，这算第二次打印
                }))
                .start();

        Thread.sleep(1000); //等会儿，确保服务端启动完成

        //::打开客户端会话
        ClientSession clientSession = SocketD.createClient("sd:tcp://127.0.0.1:8602/?u=a&p=2")
                .listen(new EventListener().doOnMessage((s, m) -> {
                    System.out.println(m);
                }).doOn("/demo", (s, m) -> { //根据消息事件路由
                    System.out.println(m);
                }))
                .open();
        
        clientSession.send("/order", new StringEntity("Hi"));
        clientSession.send("/user", new StringEntity("Hi"));
    }
}