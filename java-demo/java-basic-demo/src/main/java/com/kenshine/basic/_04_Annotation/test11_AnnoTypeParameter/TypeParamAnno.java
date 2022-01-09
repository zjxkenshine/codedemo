package com.kenshine.basic._04_Annotation.test11_AnnoTypeParameter;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 18:45
 * @description：
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER})
@Inherited
public @interface TypeParamAnno {
    String value() default "default";
}
