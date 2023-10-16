package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo07
 * @Description 链式操作符
 * @Date 2023-10-16 12:20
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo07 {
    @Assemble(container = "foo", props = @Mapping(src = "name", ref = "nested.name"))
    private Integer id;
    // nested.name 映射为foo.name
    private NestedFoo nested;
}
