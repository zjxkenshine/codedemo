package com.kenshine.flowable.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取 Bean
 * @author: kenshine
 * @create: 2019-12-17 13:12
 **/
@Component
public class SpringUtilConfig implements ApplicationContextAware {

    /**
     * 当前IOC
     *
     */
    private static ApplicationContext applicationContext;

    /**
     * * 设置当前上下文环境，此方法由spring自动装配
     *
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 从当前IOC获取bean
     *
     * @return
     *
     */
    public static <T> T getBean(Class<T> c) {
        return applicationContext.getBean(c);
    }
}
