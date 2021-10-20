package com.kenshine.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:22
 * @description：监听器
 * @modified By：
 * @version: $
 * 通过  @WebListener 或者 使用代码注册  ServletListenerRegistrationBean
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {


    /**
     * Default constructor.
     */
    public MyHttpSessionListener() {

    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    @Override
    public void sessionCreated(HttpSessionEvent se)  {
        System.out.println(se.getSession().getId()+" session create");
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se)  {
        System.out.println(se.getSession().getId()+" session destroy");
    }

}
