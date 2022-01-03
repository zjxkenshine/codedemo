package com.kenshine.profile.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 19:50
 * @description： 自定义Group注解
 * @modified By：
 * @version: $
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(GroupCondition.class)
public @interface Group {

    String value();
}
