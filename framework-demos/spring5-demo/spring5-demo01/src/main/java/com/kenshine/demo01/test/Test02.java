package com.kenshine.demo01.test;

import com.kenshine.demo01.model.Course;
import com.kenshine.demo01.model.Emp;
import com.kenshine.demo01.model.Stu;
import com.kenshine.demo01.model.User;
import com.kenshine.demo01.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/14 22:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Test02 {

    /**
     * 属性 外部bean注入
     */
    @Test
    public void testService() {
        //1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 内部Bean注入
     * 级联赋值
     */
    @Test
    public void testInnerBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.show();

        Emp emp1 = context.getBean("emp1", Emp.class);
        emp1.show();

        Emp emp2 = context.getBean("emp2", Emp.class);
        emp2.show();
    }

    /**
     * 3.xml 注入集合属性
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    /**
     * 3.xml 注入集合属性
     */
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.show();
    }

    /**
     * Factory Bean使用
     */
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        //返回值类型可以不是定义的bean类型！
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }
}
