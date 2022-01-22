package com.kenshine.bytebuddy.demo03;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.named;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 9:10
 * @description：测试修改一个类
 * @modified By：
 * @version: $
 */
public class TestModify {
    public static void main(String[] args) {
        ByteBuddyAgent.install();
        new ByteBuddy()
                //重写
                .redefine(Foo.class)
                //重写sayHelloFoo方法
                .method(named("sayHelloFoo"))
                //FixedValue 为method返回一个指定的值
                .intercept(FixedValue.value("Hello Foo 重新定义"))
                .make()
                .load(Foo.class.getClassLoader(),ClassReloadingStrategy.fromInstalledAgent());

        Foo f = new Foo();
        System.out.println(f.sayHelloFoo());
    }
}
