package com.kenshine.basic._04_Annotation.test09_AnnotationType;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:54
 * @description：
 * @modified By：
 * @version: $
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
@MetaAnno(value = "处理方式A",classes = CustomHandler.class)
public @interface CustomAnno {
}
