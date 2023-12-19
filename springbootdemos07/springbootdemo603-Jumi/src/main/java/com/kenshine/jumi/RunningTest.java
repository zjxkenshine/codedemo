package com.kenshine.jumi;

import fi.jumi.api.RunVia;
import fi.jumi.launcher.JumiBootstrap;
import fi.jumi.simpleunit.SimpleUnit;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/19 23:07
 * @description：运行测试
 * @modified By：
 * @version: $
 */
@RunVia(SimpleUnit.class)
public class RunningTest {

    public void testOne() {
        System.out.println("one");
    }

    public void testTwo() {
        System.out.println("two");
    }

    public void testThree() {
        System.out.println("three");
    }

    public void testFour() {
        System.out.println("four");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                //.setIncludedTestsPattern("glob:com/example/**Test.class"); //Java 7 glob patterns
                .setTestClasses(RunningTest.class);
        bootstrap
                // 输出调试信息
                //.enableDebugMode()
                // 输出所有信息而不是仅失败信息
                .setPassingTestsVisible(true)
                .runSuite();
    }
}
