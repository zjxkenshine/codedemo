package com.kenshine.crane4j.Test07;

import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import cn.crane4j.core.support.SimpleCrane4jGlobalConfiguration;
import cn.crane4j.core.support.reflect.DecoratedPropertyOperator;
import cn.crane4j.core.support.reflect.PropertyOperator;
import cn.crane4j.core.support.reflect.PropertyOperatorHolder;

/**
 * @author by kenshine
 * @Classname Test07OptionFactory
 * @Description 自定义CustomPropertyOperator 装饰器
 * @Date 2023-10-16 17:43
 * @modified By：
 * @version: 1.0$
 */
public class Test07OptionFactory {
    public void test(){
        Crane4jGlobalConfiguration configuration = SimpleCrane4jGlobalConfiguration.create();
        DecoratedPropertyOperator decoratedPropertyOperator = (DecoratedPropertyOperator) configuration.getPropertyOperator();
        PropertyOperator delegate = decoratedPropertyOperator.getPropertyOperator();
        delegate= new CustomPropertyOperator(delegate);
        PropertyOperatorHolder propertyOperatorHolder = new PropertyOperatorHolder(delegate);
    }
}
