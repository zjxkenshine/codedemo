package com.kenshine.limit.controller;

import idea.verlif.spring.limit.LimitHandler;
import idea.verlif.spring.limit.NotArrivedHandler;
import idea.verlif.spring.limit.anno.Limit;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname MyNotArrivedHandler
 * @Description 无法访问时处理
 * @Date 2024-05-13 15:21
 * @modified By：
 * @version: 1.0$
 */
@Component
public class MyNotArrivedHandler implements NotArrivedHandler{
    /**
     * 当被限制的接口配置了未添加的限制器时调用
     */
    @Override
    public Object noSuchHandler(Class<? extends LimitHandler> cl) {
        return null;
    }

    /**
     * 被限制器限制无法通行时触发
     */
    @Override
    public Object notArrived(Method method, Limit limit) {
        return "您的请求太频繁了";
    }
}
