package com.kenshine.crane4j.domain;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author by kenshine
 * @Classname Foo
 * @Description 待填充类
 * @Date 2023-10-16 9:45
 * @modified By：
 * @version: 1.0$
 */
@Data
@RequiredArgsConstructor
public class Foo {
    // 根据 id 填充 name
    @Assemble(container = "test", props = @Mapping(ref = "name"))
    private Integer id;
    private String name;

    public Foo(String key, String key1) {
    }

    public Foo(Integer key) {
        this.id=key;
    }
}
