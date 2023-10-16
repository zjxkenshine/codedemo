package com.kenshine.crane4j.Test01;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo02
 * @Description 类型
 * @Date 2023-10-16 11:29
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo02 {
    @Assemble(
            container = "foo", props = @Mapping(src = "a", ref = "b"),
            keyType = Integer.class // 指定 key 类型强制转为 Integer
    )
    private String id;
    private String b;
}
