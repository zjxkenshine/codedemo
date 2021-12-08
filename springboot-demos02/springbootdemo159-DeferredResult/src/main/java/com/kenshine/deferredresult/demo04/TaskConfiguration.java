package com.kenshine.deferredresult.demo04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:16
 * @description：配置线程池管理WebAsyncTask
 * @modified By：
 * @version: $
 */
@Configuration
public class TaskConfiguration {

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(10);
        taskExecutor.setThreadNamePrefix("asyncTask");
        return taskExecutor;
    }

}
