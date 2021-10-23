package com.kenshine.framework.context.support;

import com.kenshine.framework.beans.BeanDefinition;
import com.kenshine.framework.beans.factory.reader.BeanDefinitionReader;
import com.kenshine.framework.beans.factory.registry.BeanDefinitionRegistry;
import com.kenshine.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:51
 * @description：抽象应用上下文
 * @modified By：
 * @version: $
 *
 * * 作为ApplicationContext接口的子类，所以该类也是非延时加载，所以需要在该类中定义一个Map集合，作为bean对象存储的容器。
 *
 * * 声明BeanDefinitionReader类型的变量，用来进行xml配置文件的解析，符合单一职责原则。
 *   BeanDefinitionReader类型的对象创建交由子类实现，因为只有子类明确到底创建BeanDefinitionReader哪个子实现类对象
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    /** 配置加载器*/
    protected BeanDefinitionReader beanDefinitionReader;

    /** 用来存储bean对象的容器   key存储的是bean的id值，value存储的是bean对象*/
    protected Map<String, Object> singletonObjects = new HashMap<String, Object>();

    /** 存储配置文件的路径*/
    protected String configLocation;

    @Override
    public void refresh() throws IllegalStateException, Exception {

        //加载BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(configLocation);

        //初始化bean
        finishBeanInitialization();
    }

    /** bean的初始化*/
    private void finishBeanInitialization() throws Exception {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanNames = registry.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
            /** 此处用到了模板方法模式*/
            getBean(beanName);
        }
    }

}
