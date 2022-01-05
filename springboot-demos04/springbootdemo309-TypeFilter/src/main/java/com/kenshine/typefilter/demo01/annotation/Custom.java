package com.kenshine.typefilter.demo01.annotation;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 8:55
 * @description：自定义组件注册注解
 * @modified By：
 * @version: $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Custom {
}
