package com.kenshine.io.Test04_Serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 22:40
 * @description：
 * @modified By：
 * @version: $
 *
 * Externalizable与Serializable的异同
 *
 * Externalizable自定义序列化可以控制序列化的过程和决定哪些属性不被序列化。
 * Serializable序列化时不会调用默认的构造器，而Externalizable序列化时会调用默认构造器的
 * 使用Externalizable时，必须按照写入时的确切顺序读取所有字段状态。否则会产生异常。
 * 例如，如果更改UserExternal类中的number和name属性的读取顺序，则将抛出java.io.EOFException。而Serializable接口没有这个要求
 */
public class ExternalizableTest {

    @Test
    public void test(){
        try{
            testExternalizable("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test04\\userExternal.txt");
        }catch(IOException e){
            System.out.println("输入输出错误");
            e.printStackTrace();
        }

    }

    private void testExternalizable(String OUTPUT_FILE) throws IOException {
        UserExternal demo = new UserExternal();
        demo.setNumber(1004);
        demo.setName("kenshine");
        UserExternal seg = new UserExternal();

        FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        demo.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(OUTPUT_FILE);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        seg.readExternal(objectInputStream);

        System.out.println(seg);

        objectInputStream.close();
        fileInputStream.close();
    }

}
