package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Foo06
 * @Description 属性映射模板
 * @Date 2023-10-16 12:15
 * @modified By：
 * @version: 1.0$
 */
@Data
public class Foo06 {
    @Assemble(
            container = "student",
            props = {
                    @Mapping(src = "studentName", ref = "name"),
                    @Mapping(src = "studentClassName", ref = "className"),
                    @Mapping(src = "studentTeacherName", ref = "teacherName")
            }
    )
    // 使用模板映射
    @Assemble(
            container = "student",
            props = @Mapping(src = "studentTeacherAge", ref = "teacherAge"),
            propTemplates = StudentMappingTemplate.class
    )
    private Integer id;
    private String name;
    private String className;
    private String teacherName;
    private Integer teacherAge;
}
