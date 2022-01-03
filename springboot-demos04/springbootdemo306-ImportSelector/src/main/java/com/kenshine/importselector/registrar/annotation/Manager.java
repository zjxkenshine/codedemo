package com.kenshine.importselector.registrar.annotation;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 21:36
 * @description：自定义Manager注解，动态导入，模拟@Component功能
 * @modified By：
 * @version: $
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Manager {
}
