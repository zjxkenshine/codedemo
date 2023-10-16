package com.kenshine.crane4j.Test07;

import cn.crane4j.core.support.MethodInvoker;
import cn.crane4j.core.support.reflect.PropertyOperator;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author by kenshine
 * @Classname CustomPropertyOperator
 * @Description 自定义PropertyOperator
 * @Date 2023-10-16 17:43
 * @modified By：
 * @version: 1.0$
 */
public class CustomPropertyOperator implements PropertyOperator {

    public CustomPropertyOperator(PropertyOperator delegate) {
    }

    @Override
    public @Nullable MethodInvoker findGetter(Class<?> targetType, String propertyName) {
        return null;
    }

    @Override
    public @Nullable MethodInvoker findSetter(Class<?> targetType, String propertyName) {
        return null;
    }
}
