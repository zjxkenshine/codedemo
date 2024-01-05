package com.kenshine.saturn;

import com.vip.saturn.embed.spring.EmbeddedSpringSaturnApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author by kenshine
 * @Classname SaturnApp
 * @Description saturn job项目 通过executor管理
 * @Date 2024-01-05 11:31
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
public class SaturnApp {
    public static void main(String[] args) {
        SpringApplication.run(SaturnApp.class, args);
    }

    @Bean
    public EmbeddedSpringSaturnApplication embeddedSpringSaturnApplication() {
        // 需要设置System.setProperty("saturn.home","");
        EmbeddedSpringSaturnApplication embeddedSpringSaturnApplication = new EmbeddedSpringSaturnApplication();
        embeddedSpringSaturnApplication.setIgnoreExceptions(false);
        return embeddedSpringSaturnApplication;
    }
}
