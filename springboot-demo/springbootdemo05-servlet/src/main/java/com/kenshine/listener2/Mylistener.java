package com.kenshine.listener2;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:31
 * @description：监听器
 * @modified By：
 * @version: $
 */
@Component
public class Mylistener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("我开始监听"+event.getClass());
    }

}
