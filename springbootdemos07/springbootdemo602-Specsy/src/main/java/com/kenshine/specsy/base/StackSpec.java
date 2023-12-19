package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 独立执行模式
 */
public class StackSpec extends JavaSpecsy {
    private Deque<String> stack = new ArrayDeque<>();
 
    @Override
    public void run() {
        spec("空堆栈", () -> {
            spec("原本为空", () -> {
                assertTrue(stack.isEmpty());
            });
            spec("push后不再为空", () -> {
                stack.push("aa");
                assertFalse(stack.isEmpty());
            });
        });
        spec("对象推送到栈上", () -> {
            stack.push("first");
            stack.push("last");
 
            spec("后进先出", () -> {
                String poppedFirst = stack.pop();
                assertThat(poppedFirst, is("last"));
            });
            spec("先进后出", () -> {
                stack.pop();
                String poppedLast = stack.pop();
                assertThat(poppedLast, is("first"));
            });
            spec("弹出完后为空", () -> {
                stack.pop();
                stack.pop();
                assertTrue(stack.isEmpty());
            });
        });
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                // 启用断言
                .addJvmOptions("-ea")
                .setTestClasses(StackSpec.class);
        // 执行
        bootstrap
                .enableDebugMode()
                .setPassingTestsVisible(true)
                .runSuite();
    }
}