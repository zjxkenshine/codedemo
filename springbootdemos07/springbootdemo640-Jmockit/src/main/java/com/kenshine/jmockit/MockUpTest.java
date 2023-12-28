package com.kenshine.jmockit;

import com.kenshine.jmockit.mock.Fun;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname MockUpTest
 * @Description 基于状态的mock
 * @Date 2023-12-28 12:19
 * @modified By：
 * @version: 1.0$
 */
public class MockUpTest {

    /**
     * MockUp：基于状态的mock
     *
     * 想Mock哪个方法就在哪个方法上加@Mock。不加则不受影响
     * 对该类的所有对象都生效。无论是依赖注入或者new的多个实例对象，都会生效
     *
     * 缺点:
     * 对该类的所有实例都有效，一个类多个实例时不适用
     * 通过AOP动态生成的类
     */
    @Test
    public void test01() {
        // 如果想Mock某个类，只需要把这个类传入MockUp类的构造函数即可
        // 如果想Mock某个方法，就给哪个方法加上@Mock即可
        // 公有方法、私有方法、静态方法、final方法都可以Mock
        MockUp<Fun> mockUpFun = new MockUp<Fun>(Fun.class) {
            @Mock // 匿名内部类中，不能加static修饰
            public String staticFun(int x){
                return "mock static";
            }
            @Mock
            public String publicFun(int x){
                return "mock public";
            }
            @Mock // final修饰符可以省略
            public final String finalFun(int x){
                return "mock final";
            }
            @Mock // 可以使用public修饰
            private String privateFun(int x){
                return "mock private";
            }
        };

        // 使用MockUp进行方法的Mock，是对该类的所有对象都生效的。
        Fun fun = new Fun();
        // 所以此处new出来的实例也生效
        // 通过mockUpFun生成的实例也有效
        Fun fun1 = mockUpFun.getMockInstance();
        Assert.assertEquals("mock private is called",fun.callPrivateFun(10));
        Assert.assertEquals("mock static",Fun.staticFun(10));
        Assert.assertEquals("mock public",fun.publicFun(10));
        Assert.assertEquals("mock final",fun.finalFun(10));

        Assert.assertEquals("mock private is called",fun1.callPrivateFun(10));
        Assert.assertEquals("mock static",Fun.staticFun(10));
        Assert.assertEquals("mock public",fun1.publicFun(10));
        Assert.assertEquals("mock final",fun1.finalFun(10));
    }

}
