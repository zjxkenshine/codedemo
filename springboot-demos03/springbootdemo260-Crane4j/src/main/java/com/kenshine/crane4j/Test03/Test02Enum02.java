package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.ContainerEnum;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.SimpleAnnotationFinder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author by kenshine
 * @Classname Test02Enum02
 * @Description Enum02
 * @Date 2023-10-16 13:07
 * @modified By：
 * @version: 1.0$
 */
public class Test02Enum02 {
    @ContainerEnum(namespace = "AnnotatedEnum", key = "key", value = "value")
    @Getter
    @RequiredArgsConstructor
    private enum Num {
        ONE(1, "one"),
        TWO(2, "two");
        private final int key;
        private final String value;
    }

    public void test(){
        // 使用 Containers.forEnum 方法构建容器
        // 容器缓存的数据为： {1 = "one"}, {2 = "two"}
        Container<String> container = Containers.forEnum(Num.class, new SimpleAnnotationFinder(),null);
    }
}
