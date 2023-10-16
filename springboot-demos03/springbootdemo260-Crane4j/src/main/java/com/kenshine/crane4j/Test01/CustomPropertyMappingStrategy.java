package com.kenshine.crane4j.Test01;

import cn.crane4j.core.parser.PropertyMapping;
import cn.crane4j.core.parser.handler.strategy.PropertyMappingStrategy;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.Consumer;

/**
 * @author by kenshine
 * @Classname CustomPropertyMappingStrategy
 * @Description 自定义映射规则
 * @Date 2023-10-16 11:36
 * @modified By：
 * @version: 1.0$
 */
public class CustomPropertyMappingStrategy implements PropertyMappingStrategy {
    @Override
    public String getName() {
        return null;
    }

    // 映射
    @Override
    public void doMapping(Object o, Object o1, @Nullable Object o2, PropertyMapping propertyMapping, Consumer<Object> consumer) {
        // 自定义映射
    }
}
