package com.kenshine.guice.test02;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/16 16:35
 * @description：Guice三种注入方式测试
 * @modified By：
 * @version: $
 */
public class Test {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TestModule());
        TestInjection1 test = injector.getInstance(TestInjection1.class);
        test.test();
    }
}
