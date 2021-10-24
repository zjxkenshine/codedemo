package com.kenshine.rocketmq02;

import com.kenshine.rocketmq02.config.ProducerConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * https://www.jianshu.com/p/5260a2739d80
 * @author Kenshine
 */
@Log4j2
@Configuration
public class ProducerConfigure {
    @Autowired
    private ProducerConfig producerConfig;

    /**
     * 创建普通消息发送者实例
     *
     * @return
     * @throws MQClientException
     * @ConditionalOnProperty注解来控制@Configuration是否生效.
     */
//    @Bean
//    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "default", havingValue = "false")
//    public DefaultMQProducer defaultProducer() throws MQClientException {
//        log.info(producerConfig.toString());
//        log.info("defaultProducer 正在创建---------------------------------------");
//        DefaultMQProducer producer = new DefaultMQProducer(producerConfig.getGroupName());
//        producer.setNamesrvAddr(producerConfig.getNamesrvAddr());
//        producer.setVipChannelEnabled(false);
//        producer.setRetryTimesWhenSendAsyncFailed(10);
//        producer.start();
//        log.info("rocketmq producer server开启成功---------------------------------.");
//        return producer;
//    }


    /**
     * 创建事务消息发送者实例
     *
     * @return
     * @throws MQClientException
     */
    @Bean
    @ConditionalOnProperty(prefix = "rocketmq.producer", value = "transaction", havingValue = "true")
    public TransactionMQProducer transactionMQProducer() throws MQClientException {
        log.info(producerConfig.toString());
        log.info("TransactionMQProducer 正在创建---------------------------------------");
        TransactionMQProducer producer = new TransactionMQProducer(producerConfig.getGroupName());

        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("client-transaction-msg-check-thread");
                return thread;
            }
        });
        producer.setNamesrvAddr(producerConfig.getNamesrvAddr());
        producer.setExecutorService(executorService);
        producer.start();
        log.info("TransactionMQProducer server开启成功---------------------------------.");
        return producer;
    }


}
