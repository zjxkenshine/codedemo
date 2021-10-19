package com.kenshine.config;

import com.kenshine.web.HelloResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 17:19
 * @description：Jersey配置
 * @modified By：
 * @version: $
 *
 * Springboot中对Jersey的配置有三种方式：
 * 第一种方式创建一个自定义的ResourceConfig；
 * 第二种方式，返回一个ResourceConfig类型的@Bean；
 * 第三种方式，配置一组ResourceConfigCustomizer对象
 *
 * @ApplicationPath("shop")资源根路径。
 * 也可以在配置文件中使用
 * spring.jersey.application-path=shop
 */
@Configuration
@ApplicationPath("shop")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloResource.class);
    }
}
