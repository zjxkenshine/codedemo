package com.kenshine.postprocessor.custom;

import com.kenshine.postprocessor.web.TestUserController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 10:40
 * @description：TestUserController处理
 * @modified By：
 * @version: $
 */
//@Component
public class TestPostProcessor implements BeanPostProcessor {

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

}
