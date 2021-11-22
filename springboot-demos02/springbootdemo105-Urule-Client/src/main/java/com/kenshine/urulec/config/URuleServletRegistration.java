package com.kenshine.urulec.config;

import com.bstek.urule.KnowledgePackageReceiverServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/22 10:08
 * @description：配置
 * @modified By：
 * @version: $
 */
@Component
public class URuleServletRegistration {
    //此Servlet用于接收Urule服务端发布的知识包，使用开源版本时删除或者注释这个bean
    @Bean
    public ServletRegistrationBean registerURuleServlet(){
        return new ServletRegistrationBean(new KnowledgePackageReceiverServlet(),"/knowledgepackagereceiver");
    }
}
