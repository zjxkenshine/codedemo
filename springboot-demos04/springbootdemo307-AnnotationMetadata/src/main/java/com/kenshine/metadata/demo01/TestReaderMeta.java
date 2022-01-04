package com.kenshine.metadata.demo01;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:57
 * @description：元注解
 * @modified By：
 * @version: $
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TestReaderMeta {
}
