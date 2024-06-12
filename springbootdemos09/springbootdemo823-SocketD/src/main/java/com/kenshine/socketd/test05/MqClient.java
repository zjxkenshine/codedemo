package com.kenshine.socketd.test05;

import org.noear.socketd.SocketD;
import org.noear.socketd.transport.client.ClientSession;
import org.noear.socketd.transport.core.Entity;
import org.noear.socketd.transport.core.entity.StringEntity;
import org.noear.socketd.transport.core.listener.EventListener;
import org.noear.socketd.utils.StrUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author by kenshine
 * @Classname MqClient
 * @Description 客户端
 * @Date 2024-06-12 9:19
 * @modified By：
 * @version: 1.0$
 */
public class MqClient {
    private Map<String, Consumer<String>> listenerMap = new HashMap<>();
    private String server;
    private int port;
    private ClientSession clientSession;

    public MqClient(String server, int port) {
        this.server = server;
        this.port = port;
    }

    /**
     * 连接
     */
    public void connect() throws Exception {
        clientSession = SocketD.createClient("sd:udp://" + server + ":" + port)
                .config(c -> c.heartbeatInterval(5)) //心跳频率调高，确保不断连
                .listen(new EventListener()
                        .doOn("mq.broadcast", (s, m) -> {
                            String topic = m.meta("topic");
                            Consumer<String> listener = listenerMap.get(topic);
                            if (listener != null) {
                                //Qos0
                                listener.accept(m.dataAsString());
                            }
                        }))
                .open();
    }

    /**
     * 订阅消息
     */
    public void subscribe(String topic, Consumer<String> listener) throws IOException {
        listenerMap.put(topic, listener);
        //Qos0
        clientSession.send("mq.sub", new StringEntity("").metaPut("topic", topic));
    }

    /**
     * 发布消息
     */
    public void publish(String topic, String message) throws IOException {
        Entity entity = new StringEntity(message)
                .metaPut("topic", topic)
                .metaPut("id", StrUtils.guid());

        //Qos0
        clientSession.send("mq.push", entity);
    }

    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient("127.0.0.1", 8602);
        client.connect();

        client.subscribe("user.created", (message) -> {
            System.out.println(message);
        });

        client.subscribe("user.updated", (message) -> {
            System.out.println(message);
        });

        client.publish("user.created", "test");
    }
}
