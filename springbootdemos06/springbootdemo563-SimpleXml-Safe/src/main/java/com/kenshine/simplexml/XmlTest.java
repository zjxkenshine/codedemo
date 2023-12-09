package com.kenshine.simplexml;

import org.junit.Test;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.util.List;

/**
 * @author by kenshine
 * @Classname XmlTest
 * @Description 测试
 * @Date 2023-12-09 14:17
 * @modified By：
 * @version: 1.0$
 */
public class XmlTest {

    /**
     * 生成XML文件
     */
    @Test
    public void test01() {
        Person p1 = new Person("jack");
        p1.addPhone("186");
        p1.addPhone("139");
        p1.addPhone("150");

        Person p2 = new Person("rose");
        p2.addPhone("131");

        Person p3 = new Person("tom");

        PersonList personList = new PersonList();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        // 创建一个传送器对象，使用这个对象可以很快的创建和解析XML文档
        Persister persister = new Persister();

        try {
            // 将Person列表直接写出
            persister.write(personList, new File("xml\\p.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析XML文件
     */
    @Test
    public void test02() throws Exception {
        File f = new File("xml\\p.xml");
        // 创建一个传输器，执行其read方法，可以直接获取到
        PersonList pList = new Persister().read(PersonList.class, f);

        List<Person> list = pList.getList();
        // 打印输出获得的xml文件信息
        for (Person person : list) {
            System.out.println(person);
        }
    }


}
