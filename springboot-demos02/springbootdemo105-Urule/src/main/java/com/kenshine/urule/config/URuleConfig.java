package com.kenshine.urule.config;

import com.bstek.urule.KnowledgePackageReceiverServlet;
import com.bstek.urule.console.servlet.URuleServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/22 9:34
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
public class URuleConfig {
    @Bean
    public ServletRegistrationBean registerUruleServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new URuleServlet(), "/urule/*");
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean registerKnowledgeServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new KnowledgePackageReceiverServlet(), "/knowledgepackagereceiver");
        return servletRegistrationBean;
    }
}
