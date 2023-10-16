package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.ContainerConstant;
import cn.crane4j.core.container.ConstantContainerBuilder;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.SimpleAnnotationFinder;

/**
 * @author by kenshine
 * @Classname Test03Constant
 * @Description 常量容器
 * @Date 2023-10-16 13:18
 * @modified By：
 * @version: 1.0$
 */
public class Test03Constant {
    @ContainerConstant
    public static class FooConstant {
        public static final String ONE = "one";
        public static final String TWO = "two";
        public static final String THREE = "three";
    }

    public void test01(){
        // 使用 Containers.forConstantClass 方法构建容器
        // 容器缓存的数据为： {"ONE" = "one"}, {"TWO" = "two"}, {"THREE" = "three"}
        Container<Object> container = Containers.forConstantClass(FooConstant.class, new SimpleAnnotationFinder());

        // 建造者构建一个常量容器
        Container<?> container1 = ConstantContainerBuilder.of(FooConstant.class)
                .namespace("test") // 指定容器命名空间
                .onlyPublic(false) // 扫描所有公有和非公有属性
                .reverse(true) // 翻转键值对，即使用属性名作为value，属性值作为key
                .build();
    }



}
