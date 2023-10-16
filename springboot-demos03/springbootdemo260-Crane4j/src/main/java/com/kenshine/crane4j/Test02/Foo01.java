package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;

/**
 * @author by kenshine
 * @Classname Foo01
 * @Description 属性到属性
 * @Date 2023-10-16 11:48
 * @modified By：
 * @version: 1.0$
 */
public class Foo01 {
    @Assemble(
            container = "student", props = {
            @Mapping(src = "studentName", ref = "name"), // student.studentName -> Foo01.name
            @Mapping(src = "studentClassName", ref = "className") // student.studentClassName -> Foo01.className
    }
    )
    // 同名属性
    @Assemble(
            container = "student",
            props = @Mapping("name") // student.name -> Foo01.name
    )
    private Integer id;
    private String name;
    private String className;
}
