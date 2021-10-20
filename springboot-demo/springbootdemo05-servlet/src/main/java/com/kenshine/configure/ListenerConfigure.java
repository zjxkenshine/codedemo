package com.kenshine.configure;

import com.kenshine.listener.MyHttpSessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 9:26
 * @description：监听器配置
 * @modified By：
 * @version: $
 */

@Configuration
public class ListenerConfigure {

    @Bean
    public ServletListenerRegistrationBean<MyHttpSessionListener> serssionListenerBean(){
        ServletListenerRegistrationBean<MyHttpSessionListener>
                sessionListener = new ServletListenerRegistrationBean<MyHttpSessionListener>(new MyHttpSessionListener());
        return sessionListener;
    }

}
