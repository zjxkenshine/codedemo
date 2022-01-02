package com.kenshine.postprocessor.custom;

import com.kenshine.postprocessor.web.BaseController;
import com.kenshine.postprocessor.web.TestUserController;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 11:01
 * @description： SmartInstantiationAwareBeanPostProcessor 比Instantiation多处理了几个问题
 * @modified By：
 * @version: $
 */
@Component
public class TestSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
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
        if(beanClass== TestUserController.class){
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

    //实例化之前先预测bean的类型
    @Override
    @Nullable
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        if(beanClass==TestUserController.class) {
            System.out.println("预测 bean 类型:" + beanClass);
            //返回为超类
            return BaseController.class;
            //返回为其他类型 会变成其他类型的bean 这里会出错 显示两种类型bean冲突(因为同时实例化了A)
            //return A.class;
        }
        //可以在此处返回Bean类型，之后会用该类型进行处理
        //可以实例化为超类
        return null;
    }

    //确定用于给定 bean 的候选构造函数
    @Override
    @Nullable
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
            throws BeansException {
        if(beanClass==TestUserController.class){
            System.out.println("候选构造器:"+beanClass);
            return TestUserController.class.getConstructors();
        }
        //手动为bean选择构造器
        return null;
    }

    /**
     * 可以解决循环引用的问题，例如A引用了B，B引用了A，A实例化的时候，需要先实例化B，B实例化的时候又需要去实例化A，当B->实例化A的时候，就会走到这个方法，提前把A的引用暴露出去，这时候B就可以完成实例化，最后A也完成的实例化。
     */
    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        //可以提供一个bean引用进行暴露 在循环引用之前处理
        System.out.println("提前暴露引用，解决循环依赖："+beanName);
        return bean;
    }


    /**
     * 循环依赖问题
     */
    @Component
    static class B {
        @Autowired
        A a;
    }

    @Component
    static class A {
        @Autowired
        B b;
    }
}
