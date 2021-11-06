package com.kenshine.oval.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:09
 * @description：大写
 * @modified By：
 * @version: $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@net.sf.oval.configuration.annotation.Constraint(checkWith = UpperCaseCheck.class)
public @interface UpperCase {
    String message() default "must be upper case";
}
