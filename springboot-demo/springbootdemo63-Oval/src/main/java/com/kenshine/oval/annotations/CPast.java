package com.kenshine.oval.annotations;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 9:52
 * @description：自定义CPast注解
 * @modified By：
 * @version: $
 */

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD})
@Constraint(checkWith = CPastCheck.class)
public @interface CPast {
    String message() default "日期必须小于现在.";
    String dateFormat() default "yyyy-MM-dd";
}
