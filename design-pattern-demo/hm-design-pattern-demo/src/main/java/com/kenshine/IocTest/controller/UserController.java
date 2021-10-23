package com.kenshine.IocTest.controller;


import com.kenshine.IocTest.service.UserService;
import com.kenshine.framework.context.ApplicationContext;
import com.kenshine.framework.context.support.ClassPathXmlApplicationContext;


/**
 * @version v1.0
 * @ClassName: UserController
 * @Description: 测试接口
 * @Author: kenshine
 *
 * 简单来说几部分：
 * 属性值列表(MutablePropertyValues) ———— 封装bean(BeanDefinition) ————   注册表注册bean(BeanDefinitionRegistry)
 * 解析器进行注册(BeanDefinitionReader)    ————    bean工厂获取bean(BeanFactory)   ————  上下文（ApplicationContext）
 *
 */
public class UserController {
    public static void main(String[] args) throws Exception {
        //1,创建spring的容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //2,从容器对象中获取userService对象
        UserService userService = applicationContext.getBean("userService", UserService.class);
        //3,调用userService方法进行业务逻辑处理
        userService.add();
    }
}
