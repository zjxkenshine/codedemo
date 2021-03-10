package com.kenshine.rocketmq02.controller;

import com.alibaba.fastjson.JSON;
import com.kenshine.rocketmq02.TestTransactionListener;
import lombok.extern.log4j.Log4j2;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://www.jianshu.com/p/5260a2739d80
 * 这个demo中的集成方式都比较老 2019年
 * 使用starter或者springcloud组件
 * @author Kenshine
 */
@RestController
@RequestMapping("/test")
@Log4j2
public class TestController {

//    @Qualifier("defaultProducer")
//    @Autowired
//    private DefaultMQProducer producer;

    @Autowired
    private TransactionMQProducer transactionProducer;

    @Autowired
    private TestTransactionListener testTransactionListener;


//    @GetMapping("/test01")
//    public void test(String info) throws Exception {
//        System.out.println("进入test01，测试默认生产者发送异步消息");
//        //设置自动创建topic的key值
//        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
//        Message message = new Message("TopicTest", "Tag1", "12345", "rocketmq测试成功".getBytes());
//        // 这里用到了这个mq的异步处理，类似ajax，可以得到发送到mq的情况，并做相应的处理
//        //不过要注意的是这个是异步的
//        producer.send(message, new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                log.info("传输成功");
//                log.info(JSON.toJSON(sendResult));
//            }
//            @Override
//            public void onException(Throwable e) {
//                log.error("传输失败", e);
//            }
//        });
//    }


    @GetMapping("test02")
    public void Ttest(String info) throws Exception {
        System.out.println("进入test01，测试事务生产者发送事务消息");
        Message message = new Message("t_TopicTest", "Tag1", "12345", "rocketmq发送事务消息测试成功".getBytes());
        transactionProducer.setTransactionListener(testTransactionListener);
        transactionProducer.setSendMsgTimeout(10000);
        transactionProducer.sendMessageInTransaction(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("传输成功");
                log.info(JSON.toJSON(sendResult));
            }
            @Override
            public void onException(Throwable e) {
                log.error("传输失败", e);
            }
        });
    }



}
