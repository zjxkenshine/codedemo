package com.kenshine.applicationcontext.demo01;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 19:55
 * @description：spring4.3 的新特性
 * @modified By：
 * @version: $
 *
 */
@Component
public class ContextGetDemo03 implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void show (){
        System.out.println(applicationContext.getClass());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
