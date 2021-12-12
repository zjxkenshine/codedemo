package com.kenshine.picocli.example;


import picocli.CommandLine;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 20:54
 * @description：入门示例
 * @modified By：
 * @version: $
 *
 * Command注解定义命令
 */
@picocli.CommandLine.Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
public class CheckSum implements Callable<Integer> {
    /**
     * Parameters注解添加位置参数
     */
    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    /**
     * Option注解定义参数
     */
    @CommandLine.Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "MD5";

    @Override
    public Integer call() throws Exception {
        //编写你的业务逻辑
        byte[] fileContents = Files.readAllBytes(file.toPath());
        //加密相关
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        
        return 0;
    }

    // 简单示例
    public static void main(String... args) {
        int exitCode = new CommandLine(new CheckSum()).execute(args);
        System.exit(exitCode);
    }
}
