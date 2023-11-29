package com.kenshine.validator.annotation;

import com.github.houbb.validator.api.annotation.constraint.Constraint;
import com.kenshine.validator.handler.TestConstraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by kenshine
 * @Classname AllEquals
 * @Description 自定义注解
 * @Date 2023-11-29 8:37
 * @modified By：
 * @version: 1.0$
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(TestConstraint.class)
public @interface AllEquals {
    /**
     * 当前字段及其指定的字段 全部相等
     * 1. 字段类型及其他字段相同
     * @return 指定的字段列表
     */
    String[] value();

    /**
     * 提示消息
     * @return 错误提示
     */
    String message() default "";

    /**
     * 分组信息
     * @return 分组类
     * @since 0.1.2
     */
    Class[] group() default {};
}
