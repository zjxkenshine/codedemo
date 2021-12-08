package com.kenshine.deferredresult.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 9:47
 * @description：配置异步请求处理器
 * @modified By：
 * @version: $
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    public DeferredResultProcessingInterceptor customInterceptor;

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer
                //超时时间，可在构建传入参数时覆盖该配置
                .setDefaultTimeout(3000L)
                //设置异步任务执行器 AsyncTaskExecutor
                .setTaskExecutor(null)
                //注册Deferred拦截器
                .registerDeferredResultInterceptors(customInterceptor);
                //注册Callable拦截器
                //.registerCallableInterceptors();
    }
}
