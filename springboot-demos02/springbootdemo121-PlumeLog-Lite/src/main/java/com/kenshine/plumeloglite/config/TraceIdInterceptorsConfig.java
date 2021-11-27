package com.kenshine.plumeloglite.config;

import com.plumelog.core.PlumeLogTraceIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/27 8:58
 * @description：配置静态资源访问
 * @modified By：
 * @version: $
 */
@Configuration
public class TraceIdInterceptorsConfig implements WebMvcConfigurer {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //就是这句addResourceLocations，加上静态文件访问路径
        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PlumeLogTraceIdInterceptor());
    }

}
