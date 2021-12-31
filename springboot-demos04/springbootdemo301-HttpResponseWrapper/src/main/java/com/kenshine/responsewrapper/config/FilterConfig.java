package com.kenshine.responsewrapper.config;

import com.kenshine.responsewrapper.filter.GzipFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 9:31
 * @description：Filter配置
 * @modified By：
 * @version: $
 */
@Configuration
public class FilterConfig {

    /**
     * 注册GzipFilter
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new GzipFilter());
        //过滤的路径
        registration.addUrlPatterns(StringUtils.split("/test/test02,", ","));
        registration.setName("gzipFilter");
        //最高优先级
        registration.setOrder(FilterRegistrationBean.HIGHEST_PRECEDENCE);
        Map<String, String> initParameters = new HashMap<>();
        registration.setInitParameters(initParameters);
        return registration;
    }
}
