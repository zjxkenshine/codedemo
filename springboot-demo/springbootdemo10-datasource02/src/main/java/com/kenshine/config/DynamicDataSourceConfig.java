package com.kenshine.config;

import com.kenshine.datasource.DataSourceType;
import com.kenshine.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:21
 * @description：配置数据源
 * @modified By：
 * @version: $
 */
@Configuration
public class DynamicDataSourceConfig {


    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("ds1DataSource") DataSource ds1DataSource,
                                               @Qualifier("ds2DataSource") DataSource ds2DataSource) {
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.SourceType.DS_SHOP, ds1DataSource);
        targetDataSource.put(DataSourceType.SourceType.DS_USER, ds2DataSource);
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(ds2DataSource);
        return dataSource;
    }

}
