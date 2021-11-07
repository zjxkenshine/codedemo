package com.kenshine.flowable;

import com.kenshine.flowable.flowable.conf.AppDispatcherServletConfiguration;
import com.kenshine.flowable.flowable.conf.ApplicationConfiguration;
import com.kenshine.flowable.flowable.conf.DatabaseAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 16:05
 * @description：flowable测试
 * @modified By：
 * @version: $
 *
 */
@Import(value={
        // 引入修改的配置
        ApplicationConfiguration.class,
        AppDispatcherServletConfiguration.class,
        // 引入 DatabaseConfiguration 表更新转换
//        DatabaseConfiguration.class
        // 引入 DatabaseConfiguration 表更新转换
        DatabaseAutoConfiguration.class
})
@ComponentScan(basePackages = {"com.kenshine.flowable.*"})
@MapperScan("com.springcloud.*.dao")

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class FlowableApp {

    public static void main(String[] args) {
        SpringApplication.run(FlowableApp.class,args);
    }


}
