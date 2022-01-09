package com.kenshine.basic._04_Annotation.test09_AnnotationType;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:51
 * @description：自定义元注解
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
@Inherited
public @interface MetaAnno {
    String value() default "default";
    //处理类
    Class<? extends Handler> classes();
}
