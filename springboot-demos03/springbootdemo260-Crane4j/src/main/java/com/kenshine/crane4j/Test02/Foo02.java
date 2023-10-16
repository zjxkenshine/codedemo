package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;

/**
 * @author by kenshine
 * @Classname Foo2
 * @Description
 * @Date 2023-10-16 11:51
 * @modified By：
 * @version: 1.0$
 */
public class Foo02 {
    @Assemble(
            container = "student",
            props = @Mapping(ref = "student") // student -> Foo02.student
    )
    private Integer id;
    private Foo01 student;
}
