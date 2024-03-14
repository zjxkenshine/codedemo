package com.kenshine.jcasbin;

import com.kenshine.jcasbin.config.EnforcerConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author by kenshine
 * @Classname JcasbinApplication
 * @Description Jcasbin使用示例
 * @Date 2024-03-14 9:31
 * @modified By：
 * @version: 1.0$
 */
@EnableConfigurationProperties({EnforcerConfigProperties.class})
@SpringBootApplication
public class JcasbinApplication {
    public static void main(String[] args) {
        SpringApplication.run(JcasbinApplication.class,args);
    }
}
