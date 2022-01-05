package com.kenshine.io.Test01_File;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 19:46
 * @description：File类使用
 * @modified By：
 * @version: $
 *
 * 1.静态变量
 * 2.查询与判断方法
 * 3.遍历
 * 4.创建文件
 * 5.文件过滤器 FileFilter
 * 6.文件名过滤器 FileNameFilter
 */
public class FileTest {

    /**
     * 1.静态变量
     */
    @Test
    public void test01(){
        //环境变量Path路径分隔符（Win ; Linux :）
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        //文件分隔符(Win \ Linux /)
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }

    /**
     * 2.查询与判断方法
     */
    @Test
    public void test02() throws IOException {
        File file = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\aaa.txt");
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getAbsolutePath());

        System.out.println(file.isAbsolute());
        System.out.println(file.isHidden());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
    }

    /**
     * 3.遍历
     */
    @Test
    public void test03(){
        File file = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01");
        if(file.isDirectory()){
            String[] s=file.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(file.getName()+File.separator+s[i]);
                if(f.isDirectory()){
                    System.out.println(f.getName()+" is Directory");
                }else{
                    System.out.println(f.getName()+" is File");
                }
            }
        }
    }

    /**
     * 4.创建文件
     */
    @Test
    public void test04() throws IOException {
        File file = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\bbb.txt");
        //不存在时创建新文件
        file.createNewFile();

        File file1 = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\ccc.txt");
        //退出单元测试时删除
        file1.deleteOnExit();
        file1.createNewFile();
        Assert.assertTrue(file1.exists());

        File file2 = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\c");
        file2.deleteOnExit();
        //创建文件夹
        boolean result = file2.mkdir();
        Assert.assertTrue(result);
        Assert.assertTrue(file2.exists()&&file2.isDirectory());
    }

    /**
     * 5.文件过滤器 FileFilter
     */
    @Test
    public void test05_FileFilter(){
        File file = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //仅打印aaa.txt
                if(pathname.getName().contains("aaa")){
                    return true;
                }
                return false;
            }
        });
        for(File file1:files){
            System.out.println(file1.getName());
        }
    }

    /**
     * 6.文件名过滤器 FileNameFilter
     */
    @Test
    public void test06_FileNameFilter(){
        File file = new File("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01");
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.contains("bbb")){
                    return true;
                }
                return false;
            }
        });
        for(File file1:files){
            System.out.println(file1.getName());
        }
    }


}
