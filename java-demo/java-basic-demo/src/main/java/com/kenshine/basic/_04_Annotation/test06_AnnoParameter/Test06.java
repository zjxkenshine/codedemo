package com.kenshine.basic._04_Annotation.test06_AnnoParameter;

import java.lang.annotation.Annotation;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:00
 * @description：
 * @modified By：
 * @version: $
 */
public class Test06 {

    public static void test(@ParamAnno("自定义参数注解") Custom06 custom06){}

    public static void main(String[] args) throws NoSuchMethodException {
        //获取参数上的注解 解析方法需要带参数类型
        Annotation[][] annos = Test06.class.getMethod("test",Custom06.class).getParameterAnnotations();

        for (Annotation[] parameterAnnotation  : annos) {
            for (Annotation anno : parameterAnnotation ){
                if(anno instanceof ParamAnno){
                    //获取对应注解属性值
                    System.out.println(((ParamAnno) anno).value());
                }
            }
        }
    }
}
