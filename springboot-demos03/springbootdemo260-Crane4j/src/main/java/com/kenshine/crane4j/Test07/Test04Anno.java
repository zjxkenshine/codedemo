package com.kenshine.crane4j.Test07;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;

/**
 * @author by kenshine
 * @Classname Test04Anno
 * @Description 组合注解
 * @Date 2023-10-16 17:24
 * @modified By：
 * @version: 1.0$
 *
 * AnnotationFinder 可以实现类似的功能
 */
public class Test04Anno {
    // 未使用组合注解
    public class Student1 {
        @Assemble(
                key = "id", container = "student",
                props = @Mapping(src = "studentName", ref = "name")
        )
        private Integer id;
        private String name;
    }

    // 使用组合注解之后
    public class Student2 {
        @AssembleStudent
        private Integer id;
        private String name;
    }
}
