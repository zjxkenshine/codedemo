package com.kenshine.joddpetite.bean;

import jodd.petite.meta.PetiteInject;

/**
 * @author by kenshine
 * @Classname Bar
 * @Description 测试类
 * @Date 2024-03-02 8:21
 * @modified By：
 * @version: 1.0$
 */
public class Bar {
    // 组件注入
    @PetiteInject
    private Foo foo;

    // 构造方法注入
    @PetiteInject
    public Bar(Foo foo) {
        this.foo = foo;
    }

    public void bar() {
        foo.foo();
    }

    // 方法注入，根据名称
    @PetiteInject("foo")
    public void test1(Foo foo) {
        foo.foo();
    }


}
