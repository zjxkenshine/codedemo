package com.kenshine.basic._04_Annotation.test03_AnnoMulti;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 16:29
 * @description：
 * @modified By：
 * @version: $
 */
@Filters({
        @Filter("过滤器A"),
        @Filter("过滤器B")
})
public class Test {
    public static void main(String[] args) {
        //获取内部重复注解
        Filter[] filters= Test.class.getAnnotation(Filters.class).value();
        //过滤每个注解属性
        for(Filter filter:filters){
            System.out.println(filter.value());
        }
    }
}
