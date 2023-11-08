package com.kenshine.datafactory.annotation;

import com.github.houbb.data.factory.api.annotation.meta.DataMeta;

import java.lang.annotation.*;

/**
 * 自定义注解
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@DataMeta(value = AtMyStringAnnotationData.class)
public @interface ConstStringData {

    String value() default "";

}