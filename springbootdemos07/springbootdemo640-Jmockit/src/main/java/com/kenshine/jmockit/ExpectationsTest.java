package com.kenshine.jmockit;

import com.kenshine.jmockit.mock.Fun;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ExpectationsTest
 * @Description Expectations 录制
 * @Date 2023-12-28 13:06
 * @modified By：
 * @version: 1.0$
 */
public class ExpectationsTest {

    /**
     * 使用@Mocked实例化对象，Expectations不传参数
     */
    @Test
    public void test(@Mocked Fun fun/* 使用测试参数，则仅在当前测试方法起作用*/) {
        /**
         * 如果Expectations构造函数中，没有传入任何参数
         * 那么，被@Mocked注解的类(接口/抽象类)中的方法会被全部Mock掉。规则如上所述。
         * 并且，如果在Expectations中指定方法，就会按照指定的来。
         */
        new Expectations() {
            {
                fun.publicFun(1);
                result = "mock public";
                Fun.staticFun(1); // Mock 静态方法
                result = "mock static";
            }
        };

        Assert.assertEquals("mock public", fun.publicFun(1));
        // null 说明fun对象的所有方法都被使用默认规则Mock掉了
        System.out.println(fun.callPrivateFun(1));
        // mock static 说明静态方法也被Mock掉了
        System.out.println(Fun.staticFun(1));
        // 用于测试new出来的新实例
        Fun fun1 = new Fun();
        // mock public 说明如果在Expectations中指明方法的话，新实例的该方法也被指定了
        System.out.println(fun1.publicFun(1));
        // null 说明new出来的新实例对象的所有方法都被使用默认规则Mock掉了
        System.out.println(fun1.callPrivateFun(1));
    }

    /**
     * 使用@Mocked实例化对象，Expectations传入类
     */
    @Test
    public void test02(@Mocked Fun fun/* 使用测试参数，则仅在当前测试方法起作用*/){
        /**
         * 如果Expectations构造函数中，传入类
         * 那么，这个类只有在Expectations中指定的方法会被按照指定的来Mock
         * 并且，在Expectations中指定的方法是对该类的所有实例有效
         * 并且，其他没有被指定的方法并不会被Mock掉，还是执行原来的逻辑
         * 所以，这样就可以实现Mock指定类的指定方法
         */
        new Expectations(Fun.class) {
            {
                fun.publicFun(1);
                result = "mock public";
            }
        };

        Assert.assertEquals("mock public", fun.publicFun(1));
        // this is a private function 1 is called 说明没有被指定的方法还是执行原来的逻辑
        System.out.println(fun.callPrivateFun(1));
        Fun fun1 = new Fun();
        // mock public 说明新实例的指定方法也别Mock掉了
        System.out.println(fun1.publicFun(1));
        // this is a private function 1 is called 说明新实例的没有被指定的方法还是执行原来的逻辑
        System.out.println(fun1.callPrivateFun(1));
    }

    /**
     * 使用@Mocked实例化对象，Expectations传入对象
     */
    @Test
    public void test03(@Mocked Fun fun/* 使用测试参数，则仅在当前测试方法起作用*/) {
        /**
         * 如果Expectations构造函数中，传入对象
         * 那么，这个类只有在Expectations中指定的方法会被按照指定的来Mock
         * 并且，在Expectations中指定的方法是对该对象有效，对该类的其他实例无效
         * 并且，其他没有被指定的方法并不会被Mock掉，还是执行原来的逻辑
         * 所以，这样就可以实现Mock指定对象的指定方法
         */
        new Expectations(fun) {
            {
                fun.publicFun(1);
                result = "mock public";
            }
        };

        Assert.assertEquals("mock public", fun.publicFun(1));
        // this is a private function 1 is called 说明没有被指定的方法还是执行原来的逻辑
        System.out.println(fun.callPrivateFun(1));
        Fun fun1 = new Fun();
        // this is a public function 1 说明新实例的指定方法还是执行原来的逻辑
        System.out.println(fun1.publicFun(1));
        // this is a private function 1 is called 说明新实例的没有被指定的方法还是执行原来的逻辑
        System.out.println(fun1.callPrivateFun(1));
    }
}
