package com.kenshine.applicationcontext.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 19:53
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class ContextGetDemo01 {
    @Autowired
    private ApplicationContext applicationContext;

    public void show (){
        System.out.println(applicationContext.getClass());
        //获取bean
        Object object= applicationContext.getBean("contextGetDemo01");
        System.out.println(object);
    }

}
