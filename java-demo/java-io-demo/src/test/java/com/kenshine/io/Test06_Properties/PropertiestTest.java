package com.kenshine.io.Test06_Properties;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/6 8:45
 * @description：
 * @modified By：
 * @version: $
 * Properties类表示了一个持久的属性集
 * Properties集合是一个唯一和IO流相结合的集合
 * Properties集合是一个双列集合，key和value默认都是字符串
 *
 * 1.基本使用
 * 2.store 保存数据
 * 3.load 读取数据
 */
public class PropertiestTest {

    /**
     * 1.Properties基本使用
     */
    @Test
    public void test01(){
        //创建Properties集合对象
        Properties prop=new Properties();
        //使用SetProperties往集合中添加数据
        prop.setProperty("kenshine","111");
        prop.setProperty("nginx","222");
        prop.setProperty("java","333");
        //使用stringPropertyNames把Properties集合中的键取出，存储到一个Set集合中
        Set <String> keyset=prop.stringPropertyNames();
        //遍历Set集合，取出Properties集合中的每一个键
        for(String key:keyset){
            //使用getproperty方法通过key获取value
            String value=prop.getProperty(key);
            System.out.println(key+":"+value);
        }
    }

    /**
     * 2.store 保存数据
     */
    @Test
    public void test02() throws IOException {
        //1.创建Properties集合并添加数据
        Properties prop=new Properties();
        prop.setProperty("kenshine","111");
        prop.setProperty("nginx","222");
        prop.setProperty("java","333");
        prop.setProperty("elk","444");
        //2.创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        FileWriter fw=new FileWriter("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test06\\prop.txt");
        //3.使用Properties集合中的方法store,把集合中的零食数据持久化写入到文件中
        prop.store(fw,"commit");
        //4.释放资源
        fw.close();
    }

    /**
     * 3.load 读取数据
     */
    @Test
    public void test03() throws IOException {
        //1.创建Properties对象
        Properties prop=new Properties();
        //2.使用load读取文件
        prop.load(new FileReader("D:\\IdeaWorkSpace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test06\\prop.txt"));
        //3.遍历Properties集合
        Set<String> set=prop.stringPropertyNames();
        for (String s : set) {
            String value=prop.getProperty(s);
            System.out.println(s+"="+value);
        }
    }
}
