package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Before After方式一
 * @author Administrator
 */
public class DeferBlocksExampleSpec extends JavaSpecsy {
    @Override
    public void run() throws IOException {
        Path dir = Paths.get("temp-directory-" + UUID.randomUUID());
        Files.createDirectory(dir);
        defer(() -> {
            Files.delete(dir);
        });
        Path file1 = dir.resolve("file 1.txt");
        Files.createFile(file1);
        defer(() -> {
            Files.delete(file1);
        });
        spec("test01", () -> {
            System.out.println("test01");
        });
 
        spec("test02", () -> {
            // 子规范也可以使用defer块
            Path file2 = dir.resolve("file 2.txt");
            Files.createFile(file2);
            defer(() -> {
                Files.delete(file2);
            });
            // 子规范退出删除file2
        });
        // 删除file1和dir
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                // 启用断言
                .addJvmOptions("-ea")
                .setTestClasses(DeferBlocksExampleSpec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}