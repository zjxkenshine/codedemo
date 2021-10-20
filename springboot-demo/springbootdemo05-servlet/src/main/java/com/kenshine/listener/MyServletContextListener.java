package com.kenshine.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:16
 * @description：MyServletContextListener
 * @modified By：
 * @version: $
 *
 * 通过  @WebListener 或者 使用代码注册  ServletListenerRegistrationBean
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(sce.getServletContext().getServletContextName()+" init");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(sce.getServletContext().getServletContextName()+" destroy");

    }

}
