package com.kenshine.crane4j.Test01;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo03
 * @Description 知道策略
 * @Date 2023-10-16 11:31
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo03 {
    @Assemble(
            container = "foo", props = @Mapping(src = "a", ref = "b"),
            propertyMappingStrategy = "ReferenceMappingStrategy" // 指定属性映射策略
    )
    private String id;
    private String b;
}
