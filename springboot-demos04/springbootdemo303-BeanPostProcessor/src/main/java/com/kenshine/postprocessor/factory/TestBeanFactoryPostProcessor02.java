package com.kenshine.postprocessor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 18:55
 * @description：
 * @modified By：
 * @version: $
 */
@Order(2)
@Component
public class TestBeanFactoryPostProcessor02 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 二号执行了");
    }
}
