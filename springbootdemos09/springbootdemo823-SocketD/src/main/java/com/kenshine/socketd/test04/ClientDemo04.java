package com.kenshine.socketd.test04;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname ClientDemo04
 * @Description 客户端demo
 * @Date 2024-06-12 9:08
 * @modified By：
 * @version: 1.0$
 */
public class ClientDemo04 {
    public static void main(String[] args) throws IOException {
        //::打开客户端会话
        ClientSession clientSession = SocketD.createClient("sd:udp://127.0.0.1:8602/?u=a&p=2")
                .listen(new SimpleListener() {
                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        if (message.isRequest()) {
                            //答复
                            session.replyEnd(message, new StringEntity("And you too."));
                        }

                        //使用会话属性，加个计数
                        Integer count = session.attrOrDefault("count", 0);
                        session.attrPut("count", ++count);

                        if (count > 5) {
                            //超过5次后，停止互发
                            return;
                        }

                        //也主动发一个
                        session.send("/demo3", new StringEntity("Hi!"));
                    }
                })
                .open();

        //发送并请求（且，等待答复）
        clientSession.sendAndRequest("/demo", new StringEntity("hello wrold!")).await();
    }
}
