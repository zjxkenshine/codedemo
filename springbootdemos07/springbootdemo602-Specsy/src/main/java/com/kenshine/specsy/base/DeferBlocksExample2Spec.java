package com.kenshine.specsy.base;

import fi.jumi.launcher.JumiBootstrap;
import org.specsy.java.JavaSpecsy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 *
 * @author kenshine
 * Before After方式二
 */
public class DeferBlocksExample2Spec extends JavaSpecsy {
    @Override
    public void run() throws IOException {
        Path dir = createWithCleanup(Paths.get("temp-directory-" + UUID.randomUUID()), Files::createDirectory);
        Path file1 = createWithCleanup(dir.resolve("file 1.txt"), Files::createFile);
        spec("test01", () -> {
        });
        spec("test02", () -> {
            Path file2 = createWithCleanup(dir.resolve("file 2.txt"), Files::createFile);
        });
    }
 
    private Path createWithCleanup(Path path, FileCreator creator) throws IOException {
        System.out.println("Creating " + path);
        creator.create(path);
        defer(() -> {
            System.out.println("Deleting " + path);
            Files.delete(path);
        });
        return path;
    }
 
    private interface FileCreator {
        void create(Path path) throws IOException;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        JumiBootstrap bootstrap = new JumiBootstrap();
        bootstrap.suite
                // 启用断言
                .addJvmOptions("-ea")
                .setTestClasses(DeferBlocksExample2Spec.class);
        // 执行
        bootstrap
                .setPassingTestsVisible(true)
                .runSuite();
    }
}