package com.kenshine.zip4j;

import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author by kenshine
 * @Classname CompressZipTest
 * @Description zip4j组件的压缩和解压缩测试
 * @Date 2023-10-23 12:14
 * @modified By：
 * @version: 1.0$
 */
public class CompressZipTest {

    /**
     * 测试压缩文件
     */
    @Test
    public void toZipA() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File file = new File(projectHome , "源文件/哈喽.txt");
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_哈喽.zip");
        CompressZip.zip(file , zipFile);
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 测试压缩文件夹
     */
    @Test
    public void toZipB() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File file = new File(projectHome , "源文件/简单文件夹");
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_简单文件夹.zip");
        CompressZip.zip(file , zipFile);
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 测试多参数的压缩
     */
    @Test
    public void toZipC() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File file = new File(projectHome , "源文件/简单文件夹");
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_多参数_简单文件夹.zip");
        CompressZip.zip(file , zipFile , Charset.forName("GBK") , "https://www.chendd.cn" , "密码为：https://www.chendd.cn");
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 解压缩文件
     */
    @Test
    public void unZipA() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_哈喽.zip");
        File file = new File(projectHome , "解压缩文件夹/zip4j_哈喽");
        CompressZip.unzip(zipFile , file);
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 解压缩文件夹
     */
    @Test
    public void unZipB() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_简单文件夹.zip");
        File file = new File(projectHome , "解压缩文件夹/zip4j_简单文件夹");
        CompressZip.unzip(zipFile , file);
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 解压缩文件夹，包含多个参数
     */
    @Test
    public void unZipC() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_多参数_简单文件夹.zip");
        File file = new File(projectHome , "解压缩文件夹/zip4j_多参数_简单文件夹");
        CompressZip.unzip(zipFile , file , Charset.forName("GBK") , "https://www.chendd.cn");
        System.out.println("压缩源文件：" + file.getAbsolutePath());
        System.out.println("压缩后文件：" + zipFile.getAbsolutePath());
    }

    /**
     * 压缩文件预览
     */
    @Test
    public void view() {
        File projectHome = new File(System.getProperty("user.dir")).getParentFile();
        File zipFile = new File(projectHome , "压缩文件夹/zip4j_多参数_简单文件夹.zip");
        System.out.println("预览压缩包的文件：");
        List<View> list = CompressZip.view(zipFile);
        list.forEach(System.out::println);
    }

}
