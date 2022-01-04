package com.kenshine.postprocessor.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 19:03
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class TestBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor 中的 postProcessBeanDefinitionRegistry 方法执行");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanDefinitionRegistryPostProcessor 中的 postProcessBeanFactory 方法执行");
    }
}
