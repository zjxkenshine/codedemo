package com.kenshine.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 14:19
 * @description：Spring上下文工具类
 * @modified By：
 * @version: $
 */
@Service
public class SpringContextUtil implements ApplicationContextAware {

    /** 应用上下文*/
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.context = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return context.getBean(name, requiredType);
    }

}
