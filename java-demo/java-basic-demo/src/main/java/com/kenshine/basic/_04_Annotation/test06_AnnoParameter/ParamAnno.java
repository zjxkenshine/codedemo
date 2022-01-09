package com.kenshine.basic._04_Annotation.test06_AnnoParameter;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:59
 * @description：注解参数
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Inherited
public @interface ParamAnno {
    String value() default "default";
}
