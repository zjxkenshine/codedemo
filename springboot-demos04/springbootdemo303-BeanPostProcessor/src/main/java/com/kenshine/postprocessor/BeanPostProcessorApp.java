package com.kenshine.postprocessor;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 9:42
 * @description：BeanPostProcessor
 * @modified By：
 * @version: $
 */
@SpringBootApplication
public class BeanPostProcessorApp {

    public static void main(String[] args) {
        SpringApplication.run(BeanPostProcessorApp.class,args);
    }
}
