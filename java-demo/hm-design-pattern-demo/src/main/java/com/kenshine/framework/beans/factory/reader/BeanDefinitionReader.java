package com.kenshine.framework.beans.factory.reader;

import com.kenshine.framework.beans.factory.registry.BeanDefinitionRegistry;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:30
 * @description：解析配置文件并在注册表中注册bean的信息
 * @modified By：
 * @version: $
 *
 * BeanDefinitionReader是用来解析配置文件并在注册表中注册bean的信息。定义了两个规范：
 * * 获取注册表的功能，让外界可以通过该对象获取注册表对象。
 * * 加载配置文件，并注册bean数据
 */
public interface BeanDefinitionReader {

    /** 获取注册表对象*/
    BeanDefinitionRegistry getRegistry();
    /** 加载配置文件并在注册表中进行注册*/
    void loadBeanDefinitions(String configLocation) throws Exception;

}
