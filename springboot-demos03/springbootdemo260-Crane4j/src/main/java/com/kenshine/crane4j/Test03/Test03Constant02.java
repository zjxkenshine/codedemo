package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.ContainerConstant;

/**
 * @author by kenshine
 * @Classname Test03Constant02
 * @Description 可配置项
 * @Date 2023-10-16 13:21
 * @modified By：
 * @version: 1.0$
 */
public class Test03Constant02 {
    @ContainerConstant(
            namespace = "foo", // 指定命名空间
            onlyExplicitlyIncluded = true,  // 是否只保存带有 @Include 注解的属性
            onlyPublic = false // 是否只保存公共变量
    )
    public static class FooConstant2 {
        @ContainerConstant.Include      // onlyExplicitlyIncluded 为 true 时，仅包含带有该注解的属性
        public static final String ONE = "one";
        @ContainerConstant.Exclude      // 默认情况下排除该属性
        public static final String TWO = "two";
        @ContainerConstant.Name("THREE") // 指定 key 名称为 "THREE"
        private static final String SAN = "three";
    }
}
