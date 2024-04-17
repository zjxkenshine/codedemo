package com.kenshine.hornetq;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname HornetqTextMessageDemo
 * @Description hornetq连接demo
 * @Date 2024-04-17 8:31
 * @modified By：
 * @version: 1.0$
 *
 * https://www.jianshu.com/p/3d542bfeff32
 */
public class HornetqTextMessageDemo {
    public static void main(String[] args) {
        // 设置HornetQ连接信息
        Properties p = new Properties();
        p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        //p.put(Context.PROVIDER_URL, "localhost:5445");
        // hornetq-beans.xml中配置
        p.put(Context.PROVIDER_URL, "jnp://localhost:1099");

        Context context = null;
        ConnectionFactory factory = null;
        Queue queue = null;

        // 初始化连接信息，并指定连接工厂和消息队列
        try {
            context = new InitialContext(p);
            factory = (ConnectionFactory) context.lookup("/ConnectionFactory");
            queue = (Queue) context.lookup("queue/DLQ");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        // 建立连接和会话，进而发送和接收消息
        try (Connection connection = factory.createConnection(); Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);) {
            connection.start();
            produceMessage(session, queue, "Hello world!");
            consumeMessage(session, queue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void produceMessage(Session session, Queue queue, String text) {
        try (MessageProducer producer = session.createProducer(queue)) {
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
            System.out.println("Send message:" + text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void consumeMessage(Session session, Queue queue) {
        try (MessageConsumer consumer = session.createConsumer(queue)) {
            TextMessage message = (TextMessage) consumer.receive(5000);
            System.out.println("Received message:" + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
