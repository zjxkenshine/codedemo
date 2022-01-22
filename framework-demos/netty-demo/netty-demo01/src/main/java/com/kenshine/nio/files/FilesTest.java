package com.kenshine.nio.files;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/21 21:26
 * @description：
 * @modified By：
 * @version: $
 */
public class FilesTest {
    /**
     * 查找文件是否存在
     */
    @Test
    public void test01(){
        Path path = Paths.get("helloword/data.txt");
        System.out.println(Files.exists(path));
    }

    /**
     * 创建一级目录
     */
    @Test
    public void test02() throws IOException {
        Path path = Paths.get("helloword/d1");
        Files.createDirectory(path);
    }

    /**
     * 创建多级目录
     */
    @Test
    public void test03() throws IOException {
        Path path = Paths.get("helloword/d1/d2");
        Files.createDirectories(path);
    }

    /**
     * 拷贝文件与移动
     */
    @Test
    public void test04() throws IOException {
        Path source = Paths.get("helloword/data.txt");
        Path target = Paths.get("helloword/target.txt");
        Files.copy(source, target);
        //覆盖
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        //移动文件
        Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
    }

    /**
     * 删除文件和目录
     */
    @Test
    public void test05() throws IOException {
        //删除文件
        Path target = Paths.get("helloword/target.txt");
        Files.delete(target);

        //删除目录
        Path target1 = Paths.get("helloword/d1");
        Files.delete(target1);
    }

    /**
     * 使用Files工具类中的walkFileTree(Path, FileVisitor)方法
     */
    @Test
    public void test06() throws IOException {
        Path path = Paths.get("F:\\IDEAworkespace\\codedemo\\framework-demos\\netty-demo\\netty-demo01\\src\\main\\java\\com\\kenshine\\nio");
        // 文件目录数目
        AtomicInteger dirCount = new AtomicInteger();
        // 文件数目
        AtomicInteger fileCount = new AtomicInteger();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("===>"+dir);
                // 增加文件目录数
                dirCount.incrementAndGet();
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                // 增加文件数
                fileCount.incrementAndGet();
                return super.visitFile(file, attrs);
            }
        });
        // 打印数目
        System.out.println("文件目录数:"+dirCount.get());
        System.out.println("文件数:"+fileCount.get());
    }







}
