package com.kenshine.basic._04_Annotation.test04_AnnoField;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:44
 * @description：字段注解
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface FieldAnno {
   String value() default "default";
}
