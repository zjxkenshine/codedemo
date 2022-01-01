package com.kenshine.applicationcontext.demo01;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 19:55
 * @description：spring4.3 的新特性
 * @modified By：
 * @version: $
 *
 * 1 构造函数只能有一个，如果有多个，就必须有一个无参数的构造函数，此时，spring会调用无参的构造函数
 * 2 构造函数的参数，必须在spring容器中存在
 */
@Component
public class ContextGetDemo02 {
    private ApplicationContext applicationContext;

    public ContextGetDemo02(ApplicationContext applicationContext){
        System.out.println(applicationContext.getClass());
        this.applicationContext=applicationContext;
    }

    public void show (){
        System.out.println(applicationContext.getClass());
    }
}
