package com.kenshine.importselector.registrar.config;

import com.kenshine.importselector.registrar.ManagerBeanRegistrar;
import com.kenshine.importselector.registrar.TestImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 21:53
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@Import({ManagerBeanRegistrar.class, TestImportBeanDefinitionRegistrar.class})
public class ManagerConfig {
}
