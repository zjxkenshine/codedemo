package com.kenshine.rocketmq02;

import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.common.message.Message;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class TestTransactionListener extends AbstractTransactionListener {

    /**
     * 实现
     * @param msg
     * @param arg
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        log.info(new String(msg.getBody()));
        return LocalTransactionState.COMMIT_MESSAGE;
    }

}