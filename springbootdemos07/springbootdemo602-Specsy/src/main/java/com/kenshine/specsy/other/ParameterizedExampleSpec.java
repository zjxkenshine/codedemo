package com.kenshine.specsy.other;

import com.kenshine.specsy.base.ShareSideEffectsExampleSpec;
import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * 参数化测试
 */
public class ParameterizedExampleSpec extends JavaSpecsy {
    @Override
    public void run() {
        int[][] parameters = new int[][]{
                {0, 0},
                {1, 1},
                {2, 4},
                {3, 9},
                {4, 16},
                {5, 25},
                {6, 36},
                {7, 49},
                {8, 64},
                {9, 81}
        };
        for (int[] pair : parameters) {
            int n = pair[0];
            int expectedSquare = pair[1];
            spec("Square of " + n + " is " + expectedSquare, () -> {
                assertThat(n * n, is(expectedSquare));
            });
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                .addJvmOptions("-ea")
                .setTestClasses(ParameterizedExampleSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}