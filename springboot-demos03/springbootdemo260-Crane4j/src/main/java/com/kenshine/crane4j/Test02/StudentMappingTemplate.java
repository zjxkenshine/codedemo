package com.kenshine.crane4j.Test02;

import cn.crane4j.annotation.Mapping;
import cn.crane4j.annotation.MappingTemplate;

/**
 * @author by kenshine
 * @Classname StudentMappingTemplate
 * @Description 模板
 * @Date 2023-10-16 12:16
 * @modified By：
 * @version: 1.0$
 */
@MappingTemplate({
        @Mapping(src = "studentName", ref = "name"),
        @Mapping(src = "studentClassName", ref = "className"),
        @Mapping(src = "studentTeacherName", ref = "teacherName")
})
public class StudentMappingTemplate {
}
