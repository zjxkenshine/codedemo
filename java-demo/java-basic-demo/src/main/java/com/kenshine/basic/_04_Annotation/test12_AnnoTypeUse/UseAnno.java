package com.kenshine.basic._04_Annotation.test12_AnnoTypeUse;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 19:33
 * @description：自定义任意使用注解
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE})
@Inherited
public @interface UseAnno {
    String value() default "default";
}
