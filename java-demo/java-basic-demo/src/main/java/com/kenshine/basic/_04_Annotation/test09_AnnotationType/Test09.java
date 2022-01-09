package com.kenshine.basic._04_Annotation.test09_AnnotationType;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 17:52
 * @description：
 * @modified By：
 * @version: $
 */
@CustomAnno
public class Test09 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        MetaAnno metaAnno = Test09.class.getAnnotation(CustomAnno.class).getClass().getAnnotation(MetaAnno.class);
        MetaAnno metaAnno1 = CustomAnno.class.getAnnotation(MetaAnno.class);

        //获取不到
        System.out.println(metaAnno);
        //能获取到
        System.out.println(metaAnno1);
        //调用自定义处理策略
        metaAnno1.classes().getMethod("handle").invoke(metaAnno1.classes().newInstance());
    }
}
