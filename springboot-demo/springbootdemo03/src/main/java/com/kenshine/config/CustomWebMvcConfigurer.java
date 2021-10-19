package com.kenshine.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.kenshine.contentnego.resolver.JSONViewResolver;
import com.kenshine.contentnego.resolver.HtmlViewResolver;
import com.kenshine.contentnego.resolver.PdfViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 8:30
 * @description：自定义MVC配置
 * @modified By：
 * @version: $
 *
 *
 *Spring Boot2.0版本以后推荐使用这种方式来进行web配置，这样不会覆盖掉Spring Boot的一些默认配置.
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer{

    /**
     * 配置FastJsonHttpMessageConverter
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(converter);
    }

    /**
     * 添加自定义静态资源处理器
     * @param registry
     *
     * 如果两种方式都配置的话，路径冲突会以代码方式配置为准！(配置文件配置和这里配置)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置默认路径只能访问static目录下的文件
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");

        //将所有D:/resources/目录下的资源,访问时都映射到/code/** 路径下
        registry.addResourceHandler("/code/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/public/", "file:D:/resources/");
    }


    /**
     * 视图控制器配置欢迎页
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //这里的"/"是访问路径，"forward:home.html"是请求转发到的页面名称
        registry.addViewController("/").setViewName("forward:home.html");
        //设置优先级
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /**
     * 配置路径匹配模式
     * 该配置优先于配置文件配置
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //setUseSuffixPatternMatch:设置是否遵循后缀匹配模式，如“/user”是否匹配/user.*，为true时就匹配;
        configurer.setUseSuffixPatternMatch(true)
                //setUseTrailingSlashMatch,设置是否自动后缀留级匹配模式，如“/user”是否匹配“/user/”，为true是即匹配
                .setUseTrailingSlashMatch(true);
    }

    /**
     *开启支持扩展名功能
     * 优先于配置文件配置
     *
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //开启支持扩展名功能  http://localhost:8080/show.xml
        configurer.favorPathExtension(true)
        //开启内容协商的请求参数功能,默认没有开启 http://localhost:8080/show？format=json
         .favorParameter(true);
        // .useJaf(false)
        //                .favorParameter(true)
        //                .ignoreAcceptHeader(true)
        //                .defaultContentType(MediaType.APPLICATION_JSON)
        //                .mediaType("json", MediaType.APPLICATION_JSON)
        //                .mediaType("xml", MediaType.APPLICATION_XML);
    }


    /**
     * 配置视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new PdfViewResolver());
//        registry.enableContentNegotiation(new JSONViewResolver());
//        registry.enableContentNegotiation(new HtmlViewResolver());
        // 上面三个注册方法必须在此方法之上执行
        registry.enableContentNegotiation(false);
    }


    /**
     * 跨域全局配置 一般都是这种解决办法
     *
     * 跨域三种实现方案
     * 全局配置实现方案
     * 基于过滤器的实现方案
     * @CrossOrigin注解实现方案
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //针对的映射
        registry.addMapping("/**")
                //针对的origin域名
                .allowedOrigins("*")
                //针对的方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                //是否允许发送Cookie
                .allowCredentials(true)
                //从预检请求得到相应的最大时间,默认30分钟
                .maxAge(3600)
                //针对的请求头
                .allowedHeaders("*");
    }

}
