package com.kenshine.loaderjar;

import idea.verlif.loader.jar.JarLoader;
import idea.verlif.loader.jar.config.FileFilter;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author by kenshine
 * @Classname LoadJarTest
 * @Description 加载jar包
 * @Date 2024-05-13 9:01
 * @modified By：
 * @version: 1.0$
 */
public class LoadJarTest {

    /**
     * 加载文件夹jar包类信息
     */
    @Test
    public void test01(){
        JarLoader loader = new JarLoader("D:\\Github\\codedemo\\springbootdemos09\\springbootdemo806-Mark-Done\\lib");
        // 或使用以下方式
        File file = new File("D:\\Github\\codedemo\\springbootdemos09\\springbootdemo806-Mark-Done\\lib");
        JarLoader loader1 = new JarLoader(file);
        // 开始加载类信息
        loader.reload();

        // 当想要加载的jar包中的Thread实例时
        List<Thread> li = loader.getInstances(
                Thread.class,
                (Runnable) () -> System.out.println("Ok"));
        // 这里的第二个参数是可变长度参数，表示了生成实例时使用的构造方法参数
        // 然后就可以通过li列表来调用Thread了
    }

    /**
     * 加载特定jar文件
     */
    @Test
    public void test02(){
        // 新建文件过滤器
        FileFilter filter = new FileFilter();
        // 添加排除的文件总路径名(File.getAbsolutePath())正则表达式
        filter.exclude(".*beta.*", ".*test.*");
        // 添加包括的文件总路径名(File.getAbsolutePath())正则表达式
        // 使用了include(String...)后，exclude(String...)将会被无效化
        //filter.include(".*release.*", ".*alpha.*");

        // 在新建JarLoader时添加过滤器
        JarLoader loader = new JarLoader("D:\\Github\\codedemo\\springbootdemos09\\springbootdemo806-Mark-Done\\lib", filter);
        // 或是在已有的JarLoader中添加过滤器，这是需要使用reload()方法来重载加载器
        loader.setFileFilter(filter);
        loader.reload();
    }
}
