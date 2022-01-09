package com.kenshine.basic._04_Annotation.test07_AnnoConstructor;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:17
 * @description：自定义构造器注解
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR})
@Inherited
public @interface ConstructorAnno {
    String value() default "default";
}
