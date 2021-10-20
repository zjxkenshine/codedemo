package com.kenshine.listener2;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:36
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class MyEventHandler {

    @EventListener
    public void event(MyEvent event) {
        /**
         * 括号中的参数不能为空，可以任意
         * 若为Object event，则所有事件都可以监听到
         */
        System.out.println("MyEventHandler又要监听"+event.getClass());

    }
}
