package com.kenshine.bytebuddy.demo01;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 8:35
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String toString = new ByteBuddy()
                //父类
                .subclass(Object.class)
                //类名
                .name("com.kenshine.bytebuddy.Type")
                //方法
                .method(named("toString")).intercept(FixedValue.value("Hello World"))
                //创建类
                .make()
                //选择类加载器
                .load(Demo01.class.getClassLoader())
                //加载类
                .getLoaded()
                //构造一个对象
                .newInstance()
                //调用toString方法
                .toString();

        System.out.println(toString);
    }
}
