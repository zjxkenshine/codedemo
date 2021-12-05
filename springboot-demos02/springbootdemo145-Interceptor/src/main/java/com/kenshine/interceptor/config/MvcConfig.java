package com.kenshine.interceptor.config;

import com.kenshine.interceptor.interceptors.SecondInterceptor;
import com.kenshine.interceptor.interceptors.TestMethodInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 11:59
 * @description：配置拦截器
 * @modified By：
 * @version: $
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器(如果拦截器中使用了Spring bean这里需要用获取TestMethodInterceptor的bean)
        InterceptorRegistration registration = registry.addInterceptor(new TestMethodInterceptor());
        //拦截器执行顺序，也可以在拦截器类上使用@Order注解配置，小的先执行，默认按照声明顺序执行
        registration.order(3);
        //排除的路径
        registration.excludePathPatterns("/login/**");
        //执行的路径
        registration.addPathPatterns("/test/**");

        //第二个拦截器
        registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/**").order(2);
    }

    /**
     * 另一种注册方式
     * @param interceptors
     * @return
     */
//    @Bean
//    WebMvcConfigurer createWebMvcConfigurer(@Autowired HandlerInterceptor[] interceptors) {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                for (HandlerInterceptor interceptor : interceptors) {
//                    registry.addInterceptor(interceptor);
//                }
//            }
//        };
//    }

}
