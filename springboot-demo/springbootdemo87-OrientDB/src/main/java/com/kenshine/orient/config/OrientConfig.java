package com.kenshine.orient.config;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/15 22:43
 * @description：Orient配置
 * @modified By：
 * @version: $
 */
@Configuration
@Component
public class OrientConfig {
    @Value("${orient.url}")
    String url;
    @Value("${orient.database}")
    String database;
    @Value("${orient.username}")
    String username;
    @Value("${orient.password}")
    String password;

    @Bean
    public ODatabaseSession oDatabaseSession(){
        OrientDB orient = new OrientDB(url, OrientDBConfig.defaultConfig());
        return orient.open(database, username, password);
    }

}
