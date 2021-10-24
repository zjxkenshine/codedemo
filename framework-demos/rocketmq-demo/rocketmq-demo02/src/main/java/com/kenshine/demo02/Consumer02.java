package com.kenshine.demo02;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 事务消息消费者
 * @author kenshine
 */
@Component
@RocketMQMessageListener(topic = "Topic2", consumerGroup = "consumer-demo2")
public class Consumer02 implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("收到： "+s);
    }
}

