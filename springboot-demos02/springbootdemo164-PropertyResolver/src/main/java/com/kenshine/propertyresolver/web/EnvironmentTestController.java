package com.kenshine.propertyresolver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/9 23:23
 * @description：环境测试
 * @modified By：
 * @version: $
 */
@RestController
//默认配置文件源
@PropertySource("classpath:dev.properties")
public class EnvironmentTestController {
    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/test01")
    public String test01(){
        return environment.getProperty("name");
    }

    @GetMapping("/test02")
    public String test02(){
        //默认配置文件
        return context.getEnvironment().getDefaultProfiles()[0];
    }

    /**
     * 更多关于自定义配置文件的相关信息
     * https://blog.csdn.net/baidu_28523317/article/details/108701391
     */

}
