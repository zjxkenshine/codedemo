package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;

/**
 * 测试 Spec
 */
public class SampleSpec extends JavaSpecsy {
    @Override
    public void run() throws Throwable {
        // 成功
        spec("passing", () -> {
            spec("nested", () -> {
            });
        });
        // 失败
        spec("failing", () -> {
            throw new AssertionError("dummy failure");
        });
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                // 启用断言
                .addJvmOptions("-ea")
                // 匹配多个测试集
                //.setIncludedTestsPattern("glob:org/specsy/examples/**Spec.class");
                .setTestClasses(SampleSpec.class);
        // 执行
        bootstrap
                //.enableDebugMode()
                .setPassingTestsVisible(true)
                .runSuite();
    }
}