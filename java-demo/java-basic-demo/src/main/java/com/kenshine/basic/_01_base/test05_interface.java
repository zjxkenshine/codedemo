package com.kenshine.basic._01_base;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/8 22:39
 * @description：接口变化
 * @modified By：
 * @version: $
 *
 * 接口变化
 * 1.Java7及以前：
 * 常量
 * 抽象方法
 * 2.Java8新增：
 * 默认方法
 * 静态方法
 * 3.Java9新增：
 * 私有方法
 */
public class test05_interface {
    public static void main(String[] args) {
        //接口静态方法
        System.out.println(_05_A.staticMethod());
        //接口默认方法
        System.out.println(new _05_A(){}.defaultMethod());
        //接口默认方法重载
        System.out.println(new _05_A(){}.defaultMethod(1));

        //实现的两个接口默认方法冲突，必须重写
        //父类方法与接口默认方法冲突，优先使用父类方法
    }
}

interface _05_A {
    //必须手动赋值公开静态常量
    public static final int num =1;

    //jdk 9 之后 私有静态方法
    //private static String privateMethod(){};
    //jdk 9 之后 私有方法
    //private String privateMethod(){};

    static  String staticMethod(){
        return "接口静态方法";
    }
    default String defaultMethod(){
        return "接口默认方法";
    }
    default String defaultMethod(int i){
        return "接口默认方法重载";
    }

}
