package com.kenshine.basic._04_Annotation.test10_AnnoPackage;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 18:25
 * @description：自定义包注解
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PACKAGE})
@Inherited
public @interface PackageAnno {
    String version() default "0.0";
}
