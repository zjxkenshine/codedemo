package com.kenshine.fly.config;

import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 17:47
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
@EnableTransactionManagement
public class FlywayConfig {
    private static final String BASE_SQL_LOCATION = "/db2/migration";
    private static final String ENCODING = "UTF-8";

    @Resource
    private DynamicDataSourceProvider ymlDynamicDataSourceProvider;

    /**
     * 从数据库配置
     */
    @Bean
    public void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(ymlDynamicDataSourceProvider.loadDataSources().get("slave"))
                .locations(BASE_SQL_LOCATION)
                .encoding(ENCODING)
                .baselineOnMigrate(true)
                .table("base_flyway")
                .load();
        flyway.migrate();
    }

}
