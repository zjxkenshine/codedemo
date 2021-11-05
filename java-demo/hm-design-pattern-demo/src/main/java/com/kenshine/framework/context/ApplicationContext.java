package com.kenshine.framework.context;

import com.kenshine.framework.beans.factory.BeanFactory;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:48
 * @description：应用上下文接口
 * @modified By：
 * @version: $
 *
 * 该接口的所以的子实现类对bean对象的创建都是非延时的，所以在该接口中定义 `refresh()` 方法，该方法主要完成以下两个功能：
 * * 加载配置文件。
 * * 根据注册表中的BeanDefinition对象封装的数据进行bean对象的创建
 */
public interface ApplicationContext extends BeanFactory {

    /**
     *
     * @throws IllegalStateException
     * @throws Exception
     * 进行配置文件加载并进行对象创建
     */
    void refresh() throws IllegalStateException, Exception;
}
