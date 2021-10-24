package com.kenshine.demo01;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Kenshine
 */
@Component
@RocketMQMessageListener(topic = "Topic1", consumerGroup = "consumer-demo1")
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("收到： "+s);
    }


}
