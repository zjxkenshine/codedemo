package com.kenshine.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:09
 * @description：数据源配置
 * @modified By：
 * @version: $
 */
@Configuration
public class DataSourceConfig {



    /**
     * 主数据源配置 ds1数据源
     */
    @Primary
    @Bean(name = "ds1Properties")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSourceProperties ds1DataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 主数据源 ds1数据源
     *
     * @Qualifier 注解
     */
    @Primary
    @Bean(name = "ds1DataSource")
    public DataSource ds1DataSource(@Qualifier("ds1Properties") DataSourceProperties dataSourceProperties) {
        //HikariDataSource","org.apache.tomcat.jdbc.pool.DataSource", "org.apache.commons.dbcp2.BasicDataSource
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * 第二个ds2数据源配置
     */
    @Bean(name = "ds2Properties")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSourceProperties ds2DataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 第二个ds2数据源
     */
    @Bean("ds2DataSource")
    public DataSource ds2DataSource(@Qualifier("ds2Properties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
