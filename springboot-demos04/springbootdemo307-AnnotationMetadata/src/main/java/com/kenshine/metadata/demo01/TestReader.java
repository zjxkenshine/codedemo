package com.kenshine.metadata.demo01;

import com.kenshine.metadata.demo03.HandleType;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:25
 * @description：
 * @modified By：
 * @version: $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@TestReaderMeta
public @interface TestReader {
    String value() default "aaaaaaaaaa";
}
