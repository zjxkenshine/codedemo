package com.kenshine.crane4j.Test03;

import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.container.EnumContainerBuilder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author by kenshine
 * @Classname Test02Enum
 * @Description 枚举容器
 * @Date 2023-10-16 12:36
 * @modified By：
 * @version: 1.0$
 */
public class Test02Enum {
    @Getter
    @RequiredArgsConstructor
    private enum Num {
        ONE(1, "one"),
        TWO(2, "two");
        private final int code;
        private final String value;
    }

    public void test(){
        // 使用 Containers.forEnum 方法构建容器
        // 容器缓存的数据为： {1 = ONE}, {2 = TWO}
        Container<Integer> container = Containers.forEnum("num", Num.class, Num::getCode); // 指定 key 值为 code

        Container<Object> container1 = EnumContainerBuilder.of(Num.class)
                .namespace("test") // 指定命名空间
                .key("value") // 指定提供key值的属性
                .value("key") // 指定提供value值的属性
                .build();
    }

}
