package com.kenshine.demo02;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * 发送事务消息
 * @author kenshine
 */
@Component
public class Producer02 {
    @Autowired
    private RocketMQTemplate t;

    public void send() {
        Message<String> msg = MessageBuilder.withPayload("发送事务消息!").build();
        t.sendMessageInTransaction("Topic2:TagA", msg, null);
    }

    @RocketMQTransactionListener
    class Lis implements RocketMQLocalTransactionListener {
        @Override
        public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
            System.out.println("执行本地事务");
            return RocketMQLocalTransactionState.UNKNOWN;
        }

        @Override
        public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
            System.out.println("执行事务回查");
            return RocketMQLocalTransactionState.COMMIT;
        }
    }
}
