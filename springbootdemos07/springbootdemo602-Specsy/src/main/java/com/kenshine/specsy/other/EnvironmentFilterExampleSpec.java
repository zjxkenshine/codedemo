package com.kenshine.specsy.other;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.core.Closure;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;

/**
 * 仅在某些环境中执行测试
 * @author Kenshine
 */
public class EnvironmentFilterExampleSpec extends JavaSpecsy {
    @Override
    public void run() throws Throwable {
        // 任何版本
        spec("This test is run every time", () -> {
        });
        // 尽在java8以上运行
        spec("This test is run only under Java 8 and greater", () -> worksOnlyOnJava8(() -> {
        }));

        // 如果许多/所有测试仅在Java 8上工作，那么这也可以在顶层使用。
        // 只需将所有测试和变量/字段声明围成一个闭包即可。
        worksOnlyOnJava8(() -> {
 
            spec("This requires Java 8", () -> {
                // Test code...
            });
            spec("This also requires Java 8", () -> {
                // Test code...
            });
        });
    }
 
    private static void worksOnlyOnJava8(Closure closure) throws Throwable {
        if (isJava8()) {
            closure.run();
        }
    }
 
    private static boolean isJava8() {
        try {
            Class.forName("java.time.LocalDate");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                .setTestClasses(EnvironmentFilterExampleSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}