package com.kenshine.typefilter.demo02;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 9:16
 * @description：
 * @modified By：
 * @version: $
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Areaed{
    /**
     * 所属区域
     * @return
     */
    String value();

    /**
     * 描述性信息
     * @return
     */
    String description() default "";
}
