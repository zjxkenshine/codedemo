package com.kenshine.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 9:02
 * @description：ActiveMQ配置
 * @modified By：
 * @version: $
 *
 * //@EnableJms启用jms功能
 */
@Configuration
@EnableJms
public class ActivemqConfig {
    /**
     * https://blog.csdn.net/tales522/article/details/82319001
     * 环境类，读取配置
     */
    @Autowired
    private Environment env;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker-url"));
        connectionFactory.setUserName(env.getProperty("spring.activemq.user"));
        connectionFactory.setPassword(env.getProperty("spring.activemq.password"));
        return connectionFactory;
    }

    /**
     * 实现监听queue
     */
    @Bean("jmsQueueListenerContainerFactory")
    public JmsListenerContainerFactory<?> queueContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //开启接收topic类型的消息
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * 实现监听topic
     */
    @Bean("jmsTopicListenerContainerFactory")
    public JmsListenerContainerFactory<?> topicContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    /**
     * 队列名称
     */
    @Bean("springboot.queue")
    public Queue queue() {
        return new ActiveMQQueue("springboot.queue") ;
    }

    /**
     * Topic名称
     */
    @Bean("springboot.topic")
    public Topic topic() {
        return new ActiveMQTopic("springboot.topic") ;
    }


    /**
     * 回复队列名称
     */
    @Bean("springboot.replyQueue")
    public Queue queueReply() {
        return new ActiveMQQueue("springboot.replyQueue") ;
    }

}
