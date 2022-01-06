package com.kenshine.io.Test09_PrintStream;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 9:19
 * @description：打印流
 * @modified By：
 * @version: $
 *
 * System.out就是一个PrintStream
 * 1.输出到文件
 * 2.PrintStream改变输出流向
 */
public class PrintStreamTest {

    /**
     * 1. 输出到文件
     */
    @Test
    public void test01() throws FileNotFoundException {
        //1.创建PrintStream打印流对象
        PrintStream ps=new PrintStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test09\\print.txt");
        //2.使用write及特有方法
        ps.println(97);
        ps.print("这是PrintWrite打印流");
        ps.write(97);
        //3.关闭
        ps.close();
    }

    /**
     * 2.PrintStream改变输出流向
     */
    @Test
    public void test02() throws FileNotFoundException {
        System.out.println("我在控制台输出");
        PrintStream ps=new PrintStream("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test09\\print2.txt");
        System.setOut(ps); //改变流的目的地
        System.out.println("我在文件中输出");
    }

}
