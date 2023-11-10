package com.kenshine.annotation;

import com.github.houbb.sensitive.annotation.SensitiveEntry;

import java.lang.annotation.*;


/**
 * 自定义级联注解
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@SensitiveEntry
public @interface SensitiveEntryCustom {
}