package com.kenshine.web;

import com.kenshine.domain.User;
import com.kenshine.jms.Consumer;
import com.kenshine.jms.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 9:11
 * @description：消息Controller
 * @modified By：
 * @version: $
 *
 * 测试消息发布
 */
@RestController
public class MsgController {
    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    /**
     * 发送队列消息
     * p2p
     * @return
     */
    @GetMapping("/sendQueue")
    public String sendQueueMsg() {
        User user = new User();
        user.setId(1L);
        user.setUsername("kenshine queue");
        user.setPassword("123456");
        producer.sendQueueMessage(user.toString());
        return "发送成功!";
    }

    /**
     * 发送主题消息
     * 发布者/订阅
     * @return
     */
    @GetMapping("/sendTopic")
    public String sendTopicMsg() {
        User user = new User();
        user.setId(2L);
        user.setUsername("kenshine topic");
        user.setPassword("123456");
        producer.sendTopicMessage(user.toString());
        return "发送成功!";
    }

    @GetMapping("/reply")
    public String reply() {
        producer.sendQueueMessageReply("测试回复消息!");
        return "回复成功!";
    }
}
