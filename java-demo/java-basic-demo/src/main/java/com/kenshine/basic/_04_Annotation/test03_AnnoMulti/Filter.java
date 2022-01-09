package com.kenshine.basic._04_Annotation.test03_AnnoMulti;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:27
 * @description： 重复注解
 * @modified By：
 * @version: $
 */
@Repeatable(Filters.class)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Filter {
    String value() default "java";
}
