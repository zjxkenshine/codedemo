package com.kenshine.framework.beans.factory.registry;

import com.kenshine.framework.beans.BeanDefinition;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:26
 * @description：注册BeanDefinition
 * @modified By：
 * @version: $
 *
 * BeanDefinitionRegistry接口定义了注册表的相关操作，定义如下功能：
 * * 注册BeanDefinition对象到注册表中
 * * 从注册表中删除指定名称的BeanDefinition对象
 * * 根据名称从注册表中获取BeanDefinition对象
 * * 判断注册表中是否包含指定名称的BeanDefinition对象
 * * 获取注册表中BeanDefinition对象的个数
 * * 获取注册表中所有的BeanDefinition的名称
 */
public interface BeanDefinitionRegistry {

    /** 注册BeanDefinition对象到注册表中*/
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /** 从注册表中删除指定名称的BeanDefinition对象*/
    void removeBeanDefinition(String beanName) throws Exception;

    /** 根据名称从注册表中获取BeanDefinition对象*/
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /** 是否包含BeanDefinition对象*/
    boolean containsBeanDefinition(String beanName);

    /** 获取总的BeanDefinition数量*/
    int getBeanDefinitionCount();

    String[] getBeanDefinitionNames();
}
