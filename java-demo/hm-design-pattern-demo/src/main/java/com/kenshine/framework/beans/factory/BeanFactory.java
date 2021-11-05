package com.kenshine.framework.beans.factory;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:47
 * @description：Bean工厂接口
 * @modified By：
 * @version: $
 */
public interface BeanFactory {

    /**
     * 根据bean对象的名称获取bean对象
     */
    Object getBean(String name) throws Exception;
    /**
     * 根据bean对象的名称获取bean对象，并进行类型转换
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;

}
