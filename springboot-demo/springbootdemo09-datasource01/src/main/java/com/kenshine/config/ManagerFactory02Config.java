package com.kenshine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:24
 * @description：数据源管理器02
 * @modified By：
 * @version: $
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "managerFactory2", // 配置连接工厂
        transactionManagerRef = "transactionManager2", // 配置事物管理器
        basePackages = {"com.kenshine.dao.dao02"} // 设置dao所在位置
)
public class ManagerFactory02Config {


    /**
     * 配置数据源,连接第2个数据源
     */
    @Autowired
    @Qualifier("ds2DataSource")
    private DataSource ds2DataSource;

    @Bean(name = "managerFactory2")
    public LocalContainerEntityManagerFactoryBean buildEntityManagerFactory2(EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(ds2DataSource)
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.kenshine.entity")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后 EntityManager 就可以针对数据库执行操作
                .persistenceUnit("ds2PersistenceUnit")
                .build();

    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManagerDatabase1(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(buildEntityManagerFactory2(builder).getObject());
    }

}
