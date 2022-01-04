package com.kenshine.postprocessor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 18:53
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Order(1)
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 在其他任何bean实例化之前执行");
    }
}
