package com.kenshine.basic._04_Annotation.test01_AnnoBase;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:15
 * @description：自定义注解2
 * @modified By：
 * @version: $
 */
public @interface MyAnno2 {
    String value() default "custom2";
}

