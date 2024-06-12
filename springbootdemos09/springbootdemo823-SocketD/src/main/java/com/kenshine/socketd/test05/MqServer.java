package com.kenshine.socketd.test05;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.listener.EventListener;
import org.noear.socketd.utils.StrUtils;
import org.noear.socketd.transport.core.Session;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname MqServer
 * @Description 消息队列服务端
 * @Date 2024-06-12 9:17
 * @modified By：
 * @version: 1.0$
 */
public class MqServer {
    public static void main(String[] args) throws IOException {
        Set<Session> userList = new HashSet<>();

        SocketD.createServer("sd:udp")
                .config(c -> c.port(8602))
                .listen(new EventListener()
                        .doOnOpen(s -> {
                            userList.add(s);
                        })
                        .doOnClose(s -> {
                            userList.remove(s);
                        })
                        .doOn("mq.sub", (s, m) -> {
                            //::订阅指令
                            String topic = m.meta("topic");
                            if (StrUtils.isNotEmpty(topic)) {
                                //标记订阅关系
                                s.attrPut(topic, "1");
                            }
                        }).doOn("mq.push", (s, m) -> {
                            //::推送指令
                            String topic = m.meta("topic");
                            String id = m.meta("id");

                            if (StrUtils.isNotEmpty(topic) && StrUtils.isNotEmpty(id)) {
                                //开始给订阅用户广播
                                for (Session s1 : userList.stream().filter(s1 -> s.attrMap().containsKey(topic)).collect(Collectors.toList())) {
                                    //Qos0 发送广播
                                    s1.send("mq.broadcast", m);
                                }
                            }
                        })
                ).start();
    }
}
