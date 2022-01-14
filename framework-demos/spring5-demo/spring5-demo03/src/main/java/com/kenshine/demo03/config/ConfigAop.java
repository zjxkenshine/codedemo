package com.kenshine.demo03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 0:52
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@ComponentScan(basePackages = {"com.kenshine.demo03"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {

}
