package com.kenshine.socketd.test04;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.core.Message;
import org.noear.socketd.transport.core.Session;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.SimpleListener;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname ServerDemo04
 * @Description 服务端
 * @Date 2024-06-12 9:07
 * @modified By：
 * @version: 1.0$
 */
public class ServerDemo04 {
    public static void main(String[] args) throws IOException {
        //::启动服务端
        SocketD.createServer("sd:udp")
                .config(c -> c.port(8602))
                .listen(new SimpleListener() {
                    @Override
                    public void onMessage(Session session, Message message) throws IOException {
                        if (message.isRequest() || message.isSubscribe()) {
                            //答复
                            session.replyEnd(message, new StringEntity("Server receive: " + message.entity()));
                        }

                        //然后，也主动发送一个
                        session.send("/demo2", new StringEntity("Hi!"));
                    }
                })
                .start();
    }
}
