package com.kenshine.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/20 10:14
 * @description：数据源配置
 * @modified By：
 * @version: $
 *
 * 数据源配置方式一
 */

@ComponentScan
@Configuration
public class DbConfig {

    @Autowired
    private Environment env;

    /**
     * 注释掉使用其他方式
     * @return
     */
    //@Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        return dataSource;
    }

}
