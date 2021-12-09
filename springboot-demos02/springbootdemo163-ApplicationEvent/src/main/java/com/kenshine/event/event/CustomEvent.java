package com.kenshine.event.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 11:00
 * @description：自定义事件
 * @modified By：
 * @version: $
 */
public class CustomEvent extends ApplicationEvent {

    private final String message;

    /**
     *
     * @param source 发生事件的对象
     * @param message
     */
    public CustomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
