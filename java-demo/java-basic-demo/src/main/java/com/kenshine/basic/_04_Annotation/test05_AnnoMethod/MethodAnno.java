package com.kenshine.basic._04_Annotation.test05_AnnoMethod;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:51
 * @description：
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface MethodAnno {
    String value() default "default";
}
