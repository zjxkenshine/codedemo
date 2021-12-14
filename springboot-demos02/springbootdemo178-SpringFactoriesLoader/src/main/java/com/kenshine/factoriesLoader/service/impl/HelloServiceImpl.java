package com.kenshine.factoriesLoader.service.impl;

import org.springframework.beans.BeanInfoFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/14 9:11
 * @description：
 * @modified By：
 * @version: $
 */
public class HelloServiceImpl implements BeanInfoFactory{

    public HelloServiceImpl(){
        System.out.println("实例化 HelloServiceImpl");
    }


    @Override
    public BeanInfo getBeanInfo(Class<?> aClass) throws IntrospectionException {
        return null;
    }
}
