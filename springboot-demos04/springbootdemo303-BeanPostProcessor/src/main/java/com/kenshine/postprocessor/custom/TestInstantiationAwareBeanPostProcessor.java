package com.kenshine.postprocessor.custom;

import com.kenshine.postprocessor.web.TestUserController;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 10:46
 * @description：实例化处理器
 * @modified By：
 * @version: $
 */
//@Component
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestUserController){
            System.out.println("TestUserController bean 初始化之前调用");
            System.out.println(beanName);
        }
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestUserController){
            System.out.println("TestUserController bean 初始化之后调用");
            System.out.println(beanName);
        }
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        //此时还没有bean
        if(beanClass==TestUserController.class){
            System.out.println("TestUserController 实例化之前处理："+beanClass.getName());
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestUserController){
            System.out.println("TestUserController bean 实例化之后："+beanName);
        }
        return true;
    }

    @Override
    @Nullable
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        if(bean instanceof TestUserController){
            System.out.println("TestUserController bean 变量处理");
        }
        return null;
    }
}
