package com.kenshine.cxf.config;

import com.kenshine.cxf.service.DemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:29
 * @description：Cxf配置
 * @modified By：
 * @version: $
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    DemoService demoService;

        /**
         *
         * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
         * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/cxf/user?wsdl
         * @return
         */
    //    @SuppressWarnings("all")
    //    @Bean
    //    public ServletRegistrationBean dispatcherServlet() {
    //        return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");
    //    }


    /** JAX-WS
     * 站点服务
     * **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, demoService);
        endpoint.publish("/demo");
        return endpoint;
    }


}
