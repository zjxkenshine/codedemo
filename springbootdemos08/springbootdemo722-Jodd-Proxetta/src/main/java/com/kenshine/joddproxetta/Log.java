package com.kenshine.joddproxetta;

/**
 * @author by kenshine
 * @Classname Log
 * @Description 自定义注解
 * @Date 2024-03-04 8:58
 * @modified By：
 * @version: 1.0$
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
