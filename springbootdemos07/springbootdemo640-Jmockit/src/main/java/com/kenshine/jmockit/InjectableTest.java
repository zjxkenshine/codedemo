package com.kenshine.jmockit;

import com.kenshine.jmockit.mock.Fun;
import mockit.Expectations;
import mockit.Injectable;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname InjectableTest
 * @Description Injectable只针对其修饰的实例
 * @Date 2023-12-28 13:15
 * @modified By：
 * @version: 1.0$
 */
public class InjectableTest {
    /**
     * @Injectable 只针对某个实例
     */
    @Test
    public void test(@Injectable Fun fun/* 使用测试参数，则仅在当前测试方法起作用*/) {
        new Expectations() {
            {
                fun.publicFun(1);
                result = "mock public";
            }
        };

        // 说明该对象的公有方法被Mock了
        Assert.assertEquals("mock public", fun.publicFun(1));
        // this is a static function 1 说明静态方法没有被Mock
        System.out.println(Fun.staticFun(1));
        // @Injectable不会影响构造方法
        Fun fun1 = new Fun();
        // this is a public function 1 说明new的实例对象方法没有被Mock
        System.out.println(fun1.publicFun(1));
        // this is a private function 1 is called
        System.out.println(fun1.callPrivateFun(1));
    }
}
