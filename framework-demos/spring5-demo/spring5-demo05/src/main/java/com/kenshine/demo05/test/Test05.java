package com.kenshine.demo05.test;

import com.kenshine.demo05.config.TxConfig;
import com.kenshine.demo05.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 23:02
 * @description：
 * @modified By：
 * @version: $
 */
public class Test05 {

    /**
     * 注解事务管理
     */
    @Test
    public void testAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.transferMoney();
    }

    /**
     * XML事务管理
     * 去掉注解进行测试
     */
    @Test
    public void testAccount2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.transferMoney();
    }


    /**
     * 完全注解开发配置测试
     */
    @Test
    public void testAccount3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService",UserService.class);
        userService.transferMoney();
    }

}
