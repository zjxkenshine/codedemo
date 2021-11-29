package com.kenshine.objenesis.demo;

import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/29 14:27
 * @description：
 * @modified By：
 * @version: $
 */
public class Sun14Strategy implements InstantiatorStrategy {
    @Override
    public <T> ObjectInstantiator<T> newInstantiatorOf(Class<T> aClass) {
        //这里写生成ObjectInstantiator的策略
        return null;
    }



}
