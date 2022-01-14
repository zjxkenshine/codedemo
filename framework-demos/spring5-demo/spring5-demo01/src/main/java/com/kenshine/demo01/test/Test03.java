package com.kenshine.demo01.test;

import com.kenshine.demo01.autowire.Emp;
import com.kenshine.demo01.model.Orders;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 22:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Test03 {

    /**
     * Bean生命周期
     */
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建 bean 实例对象");
        System.out.println(orders);
        //手动让 bean 实例销毁
        context.close();
    }

    /**
     * 自动装配 bean标签中的autowire
     * 自动装配dept
     */
    @Test
    public void test02(){
        ApplicationContext context =   new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp01",Emp.class);
        System.out.println(emp);
    }

}
