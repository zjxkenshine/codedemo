package com.kenshine.cryptofs;

import org.cryptomator.cryptofs.CryptoFileSystemProperties;
import org.cryptomator.cryptofs.CryptoFileSystemProvider;
import org.cryptomator.cryptofs.CryptoFileSystemUri;
import org.cryptomator.cryptofs.CryptoPath;
import org.cryptomator.cryptolib.api.Masterkey;
import org.cryptomator.cryptolib.api.MasterkeyLoader;
import org.junit.Test;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author by kenshine
 * @Classname CryptofsTest
 * @Description Cryptofs 加密文件系统读取
 * @Date 2023-12-08 10:36
 * @modified By：
 * @version: 1.0$
 */
public class CryptofsTest {
    /**
     *  随机数生成
     */
    private static final SecureRandom csprng = new SecureRandom();
    private static Masterkey masterkey;

    /**
     * 创建保险库
     */
    @Test
    public void test01() throws IOException, URISyntaxException {
        // 保险库地址
        Path storageLocation = Paths.get("F:\\kenshine1");
        Files.createDirectories(storageLocation);
        // key生成
        masterkey = Masterkey.generate(csprng);
        System.out.println("kenshine".getBytes().length);
        //masterkey = new Masterkey();
        System.out.println(Arrays.toString(masterkey.getEncoded()));

        //创建一个副本，因为传递给init()方法的密钥将被销毁
        MasterkeyLoader loader = ignoredUri -> masterkey.copy();


        // CryptoFileSystemProperties 初始化加密文件系统的参数，详见springbootdemo552.md文档
        CryptoFileSystemProperties fsProps = CryptoFileSystemProperties
                .cryptoFileSystemProperties()
                .withKeyLoader(loader).build();
        // 初始化库
        CryptoFileSystemProvider.initialize(storageLocation, fsProps
                // 用于此保险库的主密钥的ID
                ,new URI("kenshine"));

        // 保存秘钥
        saveMasterKey(masterkey);
    }

    /**
     * 获取文件系统实例 方式1
     */
    @Test
    public void test02() throws IOException {
        masterkey = loadMasterKey();

        FileSystem fileSystem = CryptoFileSystemProvider.newFileSystem(
                Paths.get("F:\\kenshine1"),
                CryptoFileSystemProperties.cryptoFileSystemProperties()
                        .withKeyLoader(ignoredUri -> masterkey.copy())
                        // 读写,不设置Flags
                        // .withFlags(CryptoFileSystemProperties.FileSystemFlags.READONLY)
                        .build());

        // 使用构造的文件系统 需要以/开头
        Path testFile = fileSystem.getPath("/test02.txt");
        //Files.createDirectories(testFile.getParent());
        // 写文件
        Files.write(testFile, "test02".getBytes());
        // 文件列表
        try (Stream<Path> listing = Files.list(testFile.getParent())) {
            listing.forEach(System.out::println);
        }
    }


    /**
     * 获取文件系统实例 方式2
     */
    @Test
    public void test03() throws IOException {
        masterkey = loadMasterKey();

        URI uri = CryptoFileSystemUri.create(Paths.get("F:\\kenshine1"));
        FileSystem fileSystem = FileSystems.newFileSystem(
                uri,
                CryptoFileSystemProperties.cryptoFileSystemProperties()
                        .withKeyLoader(ignoredUri -> masterkey.copy())
                        // 读写,不设置Flags
                        // .withFlags(CryptoFileSystemProperties.FileSystemFlags.READONLY)
                        .build());

        // 使用构造的文件系统
        Path testFile = fileSystem.getPath("/test03.txt");
        Files.createDirectories(testFile.getParent());
        // 写文件
        Files.write(testFile, "test03".getBytes());
        // 文件列表
        try (Stream<Path> listing = Files.list(testFile.getParent())) {
            listing.forEach(System.out::println);
        }
    }

    /**
     * 保存秘钥
     */
    public void saveMasterKey(Masterkey masterkey) throws IOException {
        byte[] bytes=masterkey.getEncoded();
        OutputStream os = new FileOutputStream("key\\kenshine1.txt");
        os.write(bytes);
        os.close();
    }

    /**
     * 读取秘钥
     */
    public Masterkey loadMasterKey() throws IOException {
        byte[] key = new byte[64];
        int byteData;
        InputStream is = new FileInputStream("key\\kenshine1.txt");
        int index=0;
        while ((byteData = is.read()) != -1) {
            key[index]=(byte) byteData;
            index++;
        }
        return new Masterkey(key);
    }

}
