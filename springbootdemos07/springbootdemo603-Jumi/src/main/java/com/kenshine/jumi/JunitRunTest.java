package com.kenshine.jumi;

import fi.jumi.launcher.JumiBootstrap;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/19 23:27
 * @description：运行junit测试
 * @modified By：
 * @version: $
 */
public class JunitRunTest {
    @Test
    public void testOne() {
        System.out.println("one");
    }

    @Test
    public void testTwo() {
        System.out.println("two");
    }

    @Test
    public void testThree() {
        System.out.println("three");
    }

    @Test
    public void testFour() {
        System.out.println("four");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                //.setIncludedTestsPattern("glob:com/example/**Test.class"); //Java 7 glob patterns
                .setTestClasses(JunitRunTest.class);
        bootstrap
                // 输出调试信息
                //.enableDebugMode()
                // 输出所有信息而不是仅失败信息
                .setPassingTestsVisible(true)
                .runSuite();
    }
}
