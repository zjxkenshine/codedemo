package com.kenshine.querydsl.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/16 23:03
 * @description：配置
 * @modified By：
 * @version: $
 */
@Configuration
public class PeopleQueryConfig {
    @Bean
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
