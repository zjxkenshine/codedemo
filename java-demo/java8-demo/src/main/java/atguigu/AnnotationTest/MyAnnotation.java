package atguigu.AnnotationTest;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 19:44
 * @description：MyAnnotation注解
 * @modified By：
 * @version: $
 */
@Repeatable(MyAnnotations.class) //指定容器类
@Target({ElementType.TYPE, ElementType.METHOD,  ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "Java 8";
}

