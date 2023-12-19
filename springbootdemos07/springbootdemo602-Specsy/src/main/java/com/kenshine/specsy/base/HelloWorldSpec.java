package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname HelloWorldSpec
 * @Description 入门
 * @Date 2023-12-19 16:49
 * @modified By：
 * @version: 1.0$
 */
public class HelloWorldSpec extends JavaSpecsy {
    @Override
    public void run() throws Throwable {
        spec("条件1", () -> {
        });
        spec("条件2", () -> {
            spec("条件2-1", () -> {
            });
        });
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                // 启用断言
                .addJvmOptions("-ea")
                .setTestClasses(HelloWorldSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}
