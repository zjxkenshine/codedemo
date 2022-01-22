package com.kenshine.bytebuddy.demo01;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 8:42
 * @description：
 * @modified By：
 * @version: $
 */
public class Demo02 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // make完未加载的类型为 DynamicType.Unloaded
        DynamicType.Unloaded unloadedType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("Hello World ByteBuddy!"))
                .make();

        //加载类对象
        Object obj=unloadedType.load(Demo02.class.getClassLoader()).getLoaded().newInstance();
        //调用toString方法
        System.out.println(obj);
    }
}
