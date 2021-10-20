package com.kenshine.listener2;

import org.springframework.context.ApplicationEvent;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:30
 * @description：自定义事件
 * @modified By：
 * @version: $
 */
public class MyEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    public MyEvent(Object source) {
        //定义成Object类
        super(source);
    }
}
