package com.kenshine.graphql.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/15 9:26
 * @description：数据源配置
 * @modified By：
 * @version: $
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    // 对象及名称,相当于<bean>标签
    @Primary
    // 主要的候选者
    // 配置属性,prefix : 前缀 spring.datasource固定
    @ConfigurationProperties(prefix = "spring.datasource.c3p0")
    public DataSource createDataSource() {
        return DataSourceBuilder.create() // 创建数据源构建对象
                .type(ComboPooledDataSource.class) // 设置数据源类型
                .build(); // 构建数据源对象
    }

}
