package com.kenshine.demo01.test;

import com.kenshine.demo01.model.Book;
import com.kenshine.demo01.model.Orders;
import com.kenshine.demo01.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 21:24
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {

    @Test
    public void testAdd(){
        //1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2.获取配置文件创建的对象
        User user = context.getBean("user",User.class);
        System.out.println(user);
        user.add();

        //2.获取配置文件创建的对象
        Book book = context.getBean("book",Book.class);
        System.out.println(book);
        Book book3 = context.getBean("book3",Book.class);
        System.out.println(book3);

        //2.获取配置文件创建的对象
        Orders order = context.getBean("orders",Orders .class);
        System.out.println(order);
    }
}
