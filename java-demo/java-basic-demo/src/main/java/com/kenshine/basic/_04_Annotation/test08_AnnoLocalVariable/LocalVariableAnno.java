package com.kenshine.basic._04_Annotation.test08_AnnoLocalVariable;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:22
 * @description：自定义局部方法注解
 * @modified By：
 * @version: $
 */
@Documented
//局部变量注解只能在源码级别
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.LOCAL_VARIABLE})
@Inherited
public @interface LocalVariableAnno {
    String value() default "default";
}
