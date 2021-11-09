package com.kenshine.influxdb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:39
 * @description：自定义注解
 * @modified By：
 * @version: $
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Tag {

}
