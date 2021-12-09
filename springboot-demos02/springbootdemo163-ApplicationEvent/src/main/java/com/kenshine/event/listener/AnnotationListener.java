package com.kenshine.event.listener;

import com.kenshine.event.event.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:15
 * @description：监听器,注解方式
 * @modified By：
 * @version: $
 */
@Component
public class AnnotationListener {

    @EventListener
    @Order(1)
    @Async
    public void processBlackListEvent(CustomEvent event) {
        System.out.println("注解方式事件监听1："+event.getMessage()+"业务！");
    }
}
