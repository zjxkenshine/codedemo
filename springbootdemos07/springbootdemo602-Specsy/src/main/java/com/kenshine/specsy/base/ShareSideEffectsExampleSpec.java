package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 非独立执行模式
 */
public class ShareSideEffectsExampleSpec extends JavaSpecsy {
    private int counter = 0;
 
    @Override
    public void run() {
        // 开启非独立执行模式
        shareSideEffects();
        spec("One", () -> {
            counter += 1;
            assertThat(counter, is(1));
        });
        spec("Two", () -> {
            counter += 1;
            assertThat(counter, is(2));
        });
        spec("Three", () -> {
            counter += 1;
            assertThat(counter, is(3));
        });
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                .setTestClasses(ShareSideEffectsExampleSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}