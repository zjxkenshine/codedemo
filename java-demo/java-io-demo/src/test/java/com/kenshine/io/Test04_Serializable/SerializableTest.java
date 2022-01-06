package com.kenshine.io.Test04_Serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 22:39
 * @description：
 * @modified By：
 * @version: $
 *
 * Serializable是java.io包中定义的、用于实现Java类的序列化操作而提供的一个语义级别的接口
 * Serializable序列化接口没有任何方法或者字段，只是用于标识可序列化的语义
 * 实现了Serializable接口的类可以被ObjectOutputStream转换为字节流，同时也可以通过ObjectInputStream再将其解析为对象
 *
 *
 * serialVersionUID
 * 反序列化的过程中则需要使用serialVersionUID来确定由那个类来加载这个对象
 * 如果该对象的serialVersionUID与对应持久化时的类不同，那么反序列化的过程中将会导致InvalidClassException异常
 *
 * 序列化是指把对象转换为字节序列的过程，反序列化相反
 *
 * static关键字：
 *  - 静态关键字（优先于非静态加载到内存中）
 *  - 修饰的字段或方法不能进行序列化
 *
 * transient：瞬态关键字
 *  - 被transient关键字修饰的成员变量不能序列化（与static相同）
 */
public class SerializableTest {

    /**
     * 将User对象作为文本写入磁盘
     * 序列化
     */
    @Test
    public void writeObj() {
        User user = new User("1001", "Kenshine");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test04\\user.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     * 将类从文本中提取并赋值给内存中的类
     */
    @Test
    public void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test04\\user.txt"));
            try {
                Object object = objectInputStream.readObject();
                User user = (User) object;
                System.out.println(user);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
