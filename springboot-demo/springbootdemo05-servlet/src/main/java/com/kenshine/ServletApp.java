package com.kenshine;

import com.kenshine.listener2.MyEvent;
import com.kenshine.servlet.UserServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 8:38
 * @description：入口类
 * @modified By：
 * @version: $
 *
 * @ServletComponentScan 注解使用三大件都需要开启
 */
@SpringBootApplication
@ServletComponentScan
public class ServletApp {

    public static void main(String[] args){
        ConfigurableApplicationContext context=SpringApplication.run(ServletApp.class,args);

        //context.addApplicationListener(new Mylistener());//第三条：3.启动的时候，需要把监听器加入到spring容器中
        //如果这里不把监听器加入到spring容器中，那么需要在监听器类中加上@component,标注,具体见如下MyEventHandler.java
        context.publishEvent(new MyEvent(new Object()));  //发布消息
        //context.close();
    }


    /**
     *ServletRegistrationBean:注册创建的Servlet类
     */
    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new UserServlet());
        //url映射路径
        bean.addUrlMappings("/user");
        return bean;
    }

}
