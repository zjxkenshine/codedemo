package com.kenshine.dwr.config;

import org.directwebremoting.servlet.DwrListener;
import org.directwebremoting.servlet.DwrServlet;
import org.directwebremoting.spring.DwrSpringServlet;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 22:11
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class DwrConfig {

    /**
     *  加入 DWR servlet，相当于在xml中配置
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        DwrSpringServlet servlet = new DwrSpringServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet, "/dwr/*");
        //设置成true使DWR能够debug和进入测试页面。
        registrationBean.addInitParameter("debug", "true");
        //pollAndCometEnabled 设置成true能增加服务器的加载能力，尽管DWR有保护服务器过载的机制。
        registrationBean.addInitParameter("pollAndCometEnabled", "true");

        registrationBean.addInitParameter("activeReverseAjaxEnabled", "true");
        registrationBean.addInitParameter("maxWaitAfterWrite", "60");
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean dwrListener(){
        ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean(new DwrListener());
        return listener;
    }
}
