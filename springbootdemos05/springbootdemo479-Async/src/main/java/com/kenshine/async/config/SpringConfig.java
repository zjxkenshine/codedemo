package com.kenshine.async.config;

import com.github.houbb.async.spring.annotation.EnableAsync;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages = "com.kenshine.async")
@EnableAsync
public class SpringConfig {
}