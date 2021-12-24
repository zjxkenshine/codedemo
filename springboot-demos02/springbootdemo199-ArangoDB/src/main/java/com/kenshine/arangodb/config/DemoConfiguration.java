package com.kenshine.arangodb.config;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 22:28
 * @description：ArangoDB配置
 * @modified By：
 * @version: $
 */
@Configuration
@EnableArangoRepositories(basePackages = {"com.kenshine.arangodb"})
public class DemoConfiguration implements ArangoConfiguration {

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder().host("localhost", 8529).user("root").password(null);
    }

    @Override
    public String database() {
        return "demo199";
    }

}

