package com.kenshine.crane4j.Test03;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname Test06Object
 * @Description 对象容器
 * @Date 2023-10-16 14:55
 * @modified By：
 * @version: 1.0$
 */
public class Test06Object {
    // 在配置填充操作时，你可以不指定 key 值，此时，crane4j 会直接将待填充的对象作为 key 值传入容器
    @Assemble(container = "foo_info", props = @Mapping(ref = "name")) // 直接以当前的 Foo 对象作为 key，去数据源容器中查询
    @Data
    public class Foo {
        private Integer id;
        private String code;
        private String name;
    }

    // 对象容器 声明一个容器，该容器入参为待填充的 Foo 集合本身，并返回按 Foo 对象分组的数据集
    Container<Foo> objectContainer = Containers.forLambda("foo_info", fooList -> {
        fooList.stream().collect(Collectors.toMap(
                foo -> foo, foo -> foo.getId() + "#" + foo.getCode()
        ));
        return null;
    });
}
