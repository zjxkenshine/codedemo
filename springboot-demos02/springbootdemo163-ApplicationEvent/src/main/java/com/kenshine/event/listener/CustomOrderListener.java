package com.kenshine.event.listener;

import com.kenshine.event.event.CustomEvent;
import com.kenshine.event.service.CustomService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:23
 * @description：SmartApplicationListener实现调用顺序
 * @modified By：
 * @version: $
 */
@Component
public class CustomOrderListener implements SmartApplicationListener {

    /**
     * 是否是CustomEvent事件
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == CustomEvent.class;
    }

    /**
     * 发布源
     * @param sourceType
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == CustomService.class;
    }

    /**
     * 顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 3;
    }

    /**
     * 执行的
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        CustomEvent event1= (CustomEvent) event;
        System.out.println("实现方式事件监听2：即将处理"+event1.getMessage()+"业务！");
    }
}
