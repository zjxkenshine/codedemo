package com.kenshine.pattern.singleton.demo08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/17 19:18
 * @description：测试序列化破坏单例模式
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) throws Exception {
        writeObject2File();
        //两次读取地址是否相同，不相同则表示单例模式被破坏
        readObjectFromFile();
        readObjectFromFile();
    }

    //从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {
        //1,创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\86178\\Desktop\\a.txt"));
        //2,读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        //释放资源
        ois.close();
    }

    //向文件中写数据（对象）
    public static void writeObject2File() throws Exception {
        //1,获取Singleton对象
        Singleton instance = Singleton.getInstance();
        //2,创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\86178\\Desktop\\a.txt"));
        //3,写对象
        oos.writeObject(instance);
        //4,释放资源
        oos.close();
    }

}
