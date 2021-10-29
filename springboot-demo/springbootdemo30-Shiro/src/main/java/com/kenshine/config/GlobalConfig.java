package com.kenshine.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 11:11
 * @description：全局配置
 * @modified By：
 * @version: $
 *
 * jsp配置
 */
@Configuration
public class GlobalConfig {
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
        return (factory) -> {
            factory.addContextCustomizers((context) -> { //模块中webapp相对路径
                //consumer为你子项目的module名称，而不是你修改的application name这点需要注意；
                String relativePath = "springbootdemo30-Shiro/src/main/webapp";
                File docBaseFile = new File(relativePath); // 如果路径不存在，则把这个路径加入进去
                if (docBaseFile.exists()) {
                    context.setDocBase(docBaseFile.getAbsolutePath());
                }
            });
        };
    }

}
