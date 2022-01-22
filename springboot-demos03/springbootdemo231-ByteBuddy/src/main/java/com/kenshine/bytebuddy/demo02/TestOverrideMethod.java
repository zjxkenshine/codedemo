package com.kenshine.bytebuddy.demo02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 8:59
 * @description：
 * @modified By：
 * @version: $
 * 重写方法
 */
public class TestOverrideMethod {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                //类名
                .name("MyClassName")
                //定义方法 custom方法
                .defineMethod("custom", String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                //定义一个属性X
                .defineField("x", String.class, Modifier.PUBLIC)
                .make()
                .load(TestOverrideMethod.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Method m = type.getDeclaredMethod("custom", null);
        // 调用的是被intercept方法委托的 Bar中的方法
        System.out.println(m.invoke(type.newInstance()));
    }


}
