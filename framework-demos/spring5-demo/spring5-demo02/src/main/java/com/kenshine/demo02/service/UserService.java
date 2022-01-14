package com.kenshine.demo02.service;

import org.springframework.stereotype.Component;

//在注解里面 value 属性值可以省略不写，
//默认值是类名称，首字母小写
//UserService -- userService
@Component(value = "userService") //注解等同于XML配置文件：<bean id="userService" class=".."/>
public class UserService {

   public void add() {
     System.out.println("service add.......");
   }

}
