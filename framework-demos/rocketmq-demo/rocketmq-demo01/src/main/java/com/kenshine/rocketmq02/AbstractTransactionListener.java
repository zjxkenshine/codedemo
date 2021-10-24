package com.kenshine.rocketmq02;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author Kenshine
 */
@Configuration
public abstract  class AbstractTransactionListener implements TransactionListener {


    /**
     * 用作mq长时间没有收到producer的executeLocalTransaction响应的时候调用的
     * @param msg
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        return LocalTransactionState.COMMIT_MESSAGE;
    }

}
