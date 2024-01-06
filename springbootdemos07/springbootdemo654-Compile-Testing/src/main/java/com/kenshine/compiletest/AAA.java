package com.kenshine.compiletest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by kenshine
 * @Classname AAA
 * @Description 自定义注解
 * @Date 2024-01-06 11:04
 * @modified By：
 * @version: 1.0$
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface AAA {
}
