package com.kenshine.socketd.test03;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.EventListener;

/**
 * @author by kenshine
 * @Classname ClientDemo
 * @Description 连接Broker
 * @Date 2024-06-12 8:58
 * @modified By：
 * @version: 1.0$
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        ClientSession session1 = SocketD.createClient("sd:tcp://127.0.0.1:8603?@=test1")
                .listen(new EventListener().doOn("hello", (s, m) -> {
                    System.out.println(m);
                }))
                .open();

        //
        //也可以不使用集群客户端，自己创建多个会话并管理即可
        //
        ClientSession session2 =SocketD.createClusterClient("sd:tcp://127.0.0.1:8603?@=test2"
//                ,"sd:tcp://127.0.0.1:8603?@=test2",
//                "sd:tcp://127.0.0.1:8604?@=test2"
        )
                .listen(new EventListener().doOn("hello", (s, m) -> {
                    System.out.println(m);
                }))
                .open();

        // 传播消息
        session1.send("test", new StringEntity("hello").at("test2"));
        session1.send("test", new StringEntity("hello").at("test2*"));
        session1.send("test", new StringEntity("hello").at("*"));
    }
}
