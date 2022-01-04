package com.kenshine.metadata.demo03;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:07
 * @description：自定义策略注解
 * @modified By：
 * @version: $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandleType {
    String value();
}
