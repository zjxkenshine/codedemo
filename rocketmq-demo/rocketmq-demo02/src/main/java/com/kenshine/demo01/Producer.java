package com.kenshine.demo01;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class Producer {

    @Autowired
    private RocketMQTemplate t;

    public void send() {
            //发送消息
            t.convertAndSend("Topic1:TagA", "Hello world! ");

            //发送spring的Message
            t.send("Topic1:TagA", MessageBuilder.withPayload("Hello world! ").build());

            //发送异步消息
            t.asyncSend("Topic1:TagA", "Hello world!", new SendCallback() {

                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送成功");
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送失败");
                }
            });

            //发送顺序消息
            t.syncSendOrderly("Topic1", "98456237,创建", "98456237");
            t.syncSendOrderly("Topic1", "98456237,支付", "98456237");
            t.syncSendOrderly("Topic1", "98456237,完成", "98456237");
    }
}
