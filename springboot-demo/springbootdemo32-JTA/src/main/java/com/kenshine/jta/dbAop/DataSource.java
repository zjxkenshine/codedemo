package com.kenshine.jta.dbAop;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:07
 * @description：自定义数据源切换
 * @modified By：
 * @version: $
 *
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value() default DataSourceNames.ONE;
}
