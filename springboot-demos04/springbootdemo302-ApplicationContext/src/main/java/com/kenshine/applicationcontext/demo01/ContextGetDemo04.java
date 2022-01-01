package com.kenshine.applicationcontext.demo01;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 19:55
 * @description：spring4.3 的新特性
 * @modified By：
 * @version: $
 *
 */
@RestController
@RequestMapping("/test")
public class ContextGetDemo04{

    @GetMapping("/test01")
    public void show (){
        //ContextLoader获取的是XmlWebApplicationContext，这里获取不到
        ServletContext sc = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        //获取失败时 抛出异常
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println(applicationContext.getClass());
        //获取失败时 返回null
        ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
        System.out.println(ac2.getClass());
    }

    @GetMapping("/test02")
    public void show (HttpServletRequest request){
        //这个可以获取到
        ServletContext sc =request.getServletContext();
        //获取失败时 抛出异常
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        System.out.println(applicationContext.getClass());
        //获取失败时 返回null
        ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(sc);
        System.out.println(ac2.getClass());
    }


}
