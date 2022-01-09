package com.kenshine.basic._04_Annotation.test01_AnnoBase;

import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 15:55
 * @description：
 * @modified By：
 * @version: $
 *
 * 属性的返回值类型：
 * 	* 基本数据类型
 * 	* String
 * 	* 枚举
 * 	* 注解
 * 	* 以上类型的数组
 *
 * 注解不想赋值想赋值可以添加 default 给属性默认值
 * 仅一个属性需要赋值，且名称为value时，直接定义值 —— @A("val")
 * 数组赋值时，值使用{}包裹，只有一个值{}可以省略


 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    //基本类型
    int value();
    //Person是一个枚举类
    Person per();
    //其他注解
    MyAnno2 anno2();
    //数组
    String[] strs();
}
