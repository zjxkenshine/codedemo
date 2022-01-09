package com.kenshine.basic._04_Annotation.test11_AnnoTypeParameter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 19:07
 * @description：
 * @modified By：
 * @version: $
 */
public class Generic<@TypeParamAnno("泛型类参数") T,@TypeParamAnno("这是第二个泛型类参数") M> {
    T t;

    public <@TypeParamAnno("泛型方法 类型参数") E> void test(E e){}
}
