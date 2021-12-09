package com.kenshine.event.service;

import com.kenshine.event.event.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:03
 * @description：发布事件业务
 * @modified By：
 * @version: $
 */
@Service
public class CustomService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    /**
     *  设置事件发布者
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    /**
     * 调用业务前发布事件
     */
    public void sendMessage(String message) {
        //发布CustomEvent事件
        publisher.publishEvent(new CustomEvent(this, message));
        // 业务
        System.out.println(message + "业务已经被处理...");
    }

}
