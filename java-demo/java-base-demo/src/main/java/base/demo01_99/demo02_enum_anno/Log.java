package base.demo01_99.demo02_enum_anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 12:39
 * @description： 注解
 * @modified By：
 * @version: $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface Log{
    //是否开启
    boolean open() default false;
}
