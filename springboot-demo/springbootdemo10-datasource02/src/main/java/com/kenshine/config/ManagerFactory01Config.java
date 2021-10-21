package com.kenshine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:13
 * @description：配置数据源、连接工厂、事务管理器、dao目录
 * @modified By：
 * @version: $
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "managerFactory1", // 配置连接工厂
        transactionManagerRef = "transactionManager1", // 配置事物管理器
        basePackages = {"com.kenshine.dao.dao01"} // 设置dao所在位置
)
public class ManagerFactory01Config {

    /**
     * 配置数据源,连接第1个数据源
     */
    @Autowired
    @Qualifier("ds1DataSource")
    private DataSource ds1DataSource;

    /**
     *
     * @param builder
     * @return
     *
     *  @Primary注解作用
     *  @Primary注解的作用其实就是相当于默认值，在众多实现类中给他一个这样的注解就会在不指定调用哪个bean类时会默认调用有这个注解的方法
     *
     */
    @Primary
    @Bean(name = "managerFactory1")
    public LocalContainerEntityManagerFactoryBean buildEntityManagerFactory1(EntityManagerFactoryBuilder builder) {
        return builder
                // 设置数据源
                .dataSource(ds1DataSource)
                //设置实体类所在位置.扫描所有带有 @Entity 注解的类
                .packages("com.kenshine.entity")
                // Spring会将EntityManagerFactory注入到Repository之中.有了 EntityManagerFactory之后,
                // Repository就能用它来创建 EntityManager 了,然后 EntityManager 就可以针对数据库执行操作
                .persistenceUnit("ds1PersistenceUnit")
                .build();

    }

    /**
     * 配置事务管理器
     */
    @Bean(name = "transactionManager1")
    public PlatformTransactionManager transactionManagerDatabase1(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(buildEntityManagerFactory1(builder).getObject());
    }


}
