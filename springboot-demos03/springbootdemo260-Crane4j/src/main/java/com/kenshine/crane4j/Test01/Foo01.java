package com.kenshine.crane4j.Test01;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo
 * @Description 声明
 * @Date 2023-10-16 11:27
 * @modified By：
 * @version: 1.0$
 */
@Data
// 类声明
@Assemble(
        key = "id", // 手动指定绑定到 id 字段上
        container = "student",
        props = @Mapping(src = "studentName", ref = "name")
)
public class Foo01 {
    // 属性声明，重复声明
    @Assemble(container = "user_role", props = @Mapping(src = "role", ref = "role"))
    @Assemble(container = "user", props = @Mapping(src = "name", ref = "name"))
    private Integer id;
    private String name;
    private String role;
}
