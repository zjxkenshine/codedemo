package com.kenshine.demo03.test;

import com.kenshine.demo03.aop.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 0:40
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01 {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }
}
