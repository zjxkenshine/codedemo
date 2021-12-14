package com.kenshine.aware.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 22:49
 * @description：测试
 * @modified By：
 * @version: $
 */
@Configuration
public class TestAware implements EnvironmentAware, ApplicationContextAware {
    /**
     * setEnvironment注入environment
     */
    private Environment environment;

    public static ApplicationContext context;

    @Override
    public void setEnvironment(Environment environment) {
        String projectName = environment.getProperty("spring.application.name");
        System.out.println("应用名称为："+projectName);
        this.environment = environment;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //设置静态属性
        context=applicationContext;
    }

    /**
     * 获取bean对象
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        Object object = null;
        object = context.getBean(name);
        return object;
    }


}
