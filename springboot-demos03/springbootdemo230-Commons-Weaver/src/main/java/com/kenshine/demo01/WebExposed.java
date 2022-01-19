package com.kenshine.demo01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/19 10:04
 * @description：
 * @modified By：
 * @version: $
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface WebExposed {
}
