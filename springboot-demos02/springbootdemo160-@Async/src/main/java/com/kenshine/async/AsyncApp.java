package com.kenshine.async;

import com.kenshine.async.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 10:51
 * @description：异步调用App
 * @modified By：
 * @version: $
 */
@Component
@EnableAsync//开启异步调用
@SpringBootApplication
public class AsyncApp {
    @Autowired
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class, args);
    }

    /**
     * 启动成功
     */
    @Bean
    public ApplicationRunner applicationRunner() {
        return applicationArguments -> {
            long startTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
            //无返回值
            //testService.asyncTask();

            //有返回值，但主线程不需要用到返回值
            //Future<String> future = testService.asyncTask("kenshine");
            //有返回值，且主线程需要用到返回值
            //System.out.println(Thread.currentThread().getName() + "：返回值：" + testService.asyncTask("kenshine").get());

            //事务测试，事务正常提交
            //testService.asyncTaskForTransaction(false);
            //事务测试，模拟异常事务回滚
            testService.asyncTaskForTransaction(true);

            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
        };
    }

}
