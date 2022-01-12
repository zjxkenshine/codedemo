package com.kenshine.log4j2;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({JunitTest.class,JunitTest02.class})
public class SuitTest {
    /**
     * 测试套件
     * 不需要主体
     * 会同时运行JunitTest和JunitTest02测试类
     */

}
