package com.kenshine.crane4j.Test07;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.Mapping;

import java.lang.annotation.*;

// 将目标注解作为元注解
@Assemble(key = "id", container = "student", props = @Mapping(src = "studentName", ref = "name"))
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AssembleStudent { }