package com.kenshine.bytebuddy.demo02;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 8:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Bar {

    /**
     * 多个返回值相同的方法使用 BindingPriority 区分
     * 调用值大的
     */
    @BindingPriority(1)
    public static String sayHelloBar() {
        return "Holla in Bar!";
    }

    @BindingPriority(2)
    public static String sayBar() {
        return "bar";
    }
}
