package com.kenshine.crane4j.Test06;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Disassemble;
import cn.crane4j.annotation.Mapping;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Test04Group
 * @Description 分组
 * @Date 2023-10-16 16:52
 * @modified By：
 * @version: 1.0$
 */
public class Test04Group {
    public class UserVO {
        // Assemble 分组
        @Assemble(container = "user", props = @Mapping(src = "role", ref = "role"), groups = "admin")
        @Assemble(container = "user", props = @Mapping(src = "name", ref = "name"), groups = {"base", "admin"})
        private Integer id;
        private String name;
        private String role;
    }

    public class Foo {
        @Assemble(container = "user", props = @Mapping(src = "name", ref = "name"), groups = "admin")
        private Integer id;
        private String name;
        // Disassemble 分组
        @Disassemble(type = Foo.class, groups = "nested")
        private List<Foo> fooList;
    }
}
