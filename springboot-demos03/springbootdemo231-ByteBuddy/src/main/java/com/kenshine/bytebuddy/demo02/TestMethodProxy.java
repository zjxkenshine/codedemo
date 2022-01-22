package com.kenshine.bytebuddy.demo02;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/22 8:49
 * @description：
 * @modified By：
 * @version: $
 */
public class TestMethodProxy {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String r = new ByteBuddy()
                // 父类为Foo
                .subclass(Foo.class)
                // 创建 sayHelloFoo方法
                .method(named("sayHelloFoo")
                        .and(isDeclaredBy(Foo.class)
                                .and(returns(String.class))))
                //通过方法委托的方式实现代理 委托给Bar中的方法
                //sayHelloBar()的返回类型和sayHelloFoo()方法一致
                //多个返回值相同的方法使用 @BindingPriority 注解区分
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(TestMethodProxy.class.getClassLoader())
                .getLoaded()
                .newInstance()
                //调用 sayHelloFoo 方法
                .sayHelloFoo();

        System.out.println(r);
    }

}
