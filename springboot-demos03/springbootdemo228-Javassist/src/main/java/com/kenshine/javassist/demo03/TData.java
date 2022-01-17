package com.kenshine.javassist.demo03;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/17 17:07
 * @description：测试
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface TData {

}
