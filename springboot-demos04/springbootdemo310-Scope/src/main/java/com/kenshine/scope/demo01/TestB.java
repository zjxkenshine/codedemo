package com.kenshine.scope.demo01;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 8:58
 * @description：
 * @modified By：
 * @version: $
 *
 * Scope的全部可选项
 *      singleton 全局只有一个实例，即单例模式
 *      prototype 每次注入Bean都是一个新的实例
 *      request 每次HTTP请求都会产生新的Bean
 *      session 每次HTTP请求都会产生新的Bean，该Bean在仅在当前session内有效
 *      global session 每次HTTP请求都会产生新的Bean，该Bean在 当前global Session（基于portlet的web应用中）内有效
 */
@Component
@Scope(DefaultListableBeanFactory.SCOPE_PROTOTYPE)
public class TestB {
    /**
     * B会被实例化两次
     */
    public TestB() {
        System.out.println("B被实例化了");
    }
}
