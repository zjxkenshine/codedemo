package com.kenshine.crane4j.config;

import cn.crane4j.core.container.Container;
import cn.crane4j.core.container.Containers;
import cn.crane4j.core.support.Crane4jGlobalConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname SourceConfig
 * @Description 数据源配置
 * @Date 2023-10-16 9:41
 * @modified By：
 * @version: 1.0$
 */
@Configuration
public class SourceConfig {
    // 从 Spring 容器中获取全局配置
    @Autowired
    private Crane4jGlobalConfiguration configuration;

    //配置数据源
    @Bean
    public void config() {
        // 基于 Map 集合创建一个数据源容器
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        // 一个数据源对应一个数据源容器（Container），它们通过独一无二的命名空间 （namespace）进行区分
        Container<Integer> container = Containers.forMap("test", map);

        // 将数据源容器注册到全局配置中
        configuration.registerContainer(container);
    }
}
