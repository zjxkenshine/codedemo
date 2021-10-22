package com.kenshine.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 9:08
 * @description：Neo4j的配置类
 * @modified By：
 * @version: $
 *
 * @EnableNeo4jRepositories Neo4j扫描Repositories所在包，理解为mybatis扫描mapper包
 */
@Configuration
@EnableNeo4jRepositories(basePackages = "com.kenshine.repository")
@EnableTransactionManagement
public class Neo4jConfig {
    /**
     * 最简单配置  空Neo4jConfig什么都不写 这里配置了session
     */

    @Value("${spring.data.neo4j.uri}")
    private String url;

    @Value("${spring.data.neo4j.username}")
    private String username;

    @Value("${spring.data.neo4j.password}")
    private String password;

    @Bean(name = "session")
    public Session neo4jSession() {
        Driver driver = GraphDatabase.driver(url, AuthTokens.basic(username, password));
        return driver.session();
    }

}
