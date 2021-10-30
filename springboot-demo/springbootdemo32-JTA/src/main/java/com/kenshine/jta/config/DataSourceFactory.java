package com.kenshine.jta.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.kenshine.jta.dbAop.DataSourceNames;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:16
 * @description：多数据源配置
 * @modified By：
 * @version: $
 */
@Configuration
@MapperScan(basePackages = DataSourceFactory.BASE_PACKAGES, sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceFactory {
    static final String BASE_PACKAGES = "com.kenshine.jta.mapper";

    private static final String MAPPER_LOCATION = "classpath:mybatis/mapper/*.xml";

    /***
     * 创建 DruidXADataSource mydbone 用@ConfigurationProperties 自动配置属性
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.mydbone")
    public DataSource druidDataSourceOne() {
        return new DruidXADataSource();
    }

    /***
     * 创建 DruidXADataSource mydbtwo
     */
    @Bean
    @ConfigurationProperties("spring.datasource.druid.mydbtwo")
    public DataSource druidDataSourceTwo() {
        return new DruidXADataSource();
    }

    /**
     * 创建支持 XA 事务的 Atomikos 数据源 mydbone
     */
    @Bean
    public DataSource dataSourceOne(DataSource druidDataSourceOne) {
        AtomikosDataSourceBean sourceBean = new AtomikosDataSourceBean();
        sourceBean.setXaDataSource((DruidXADataSource) druidDataSourceOne);
        // 必须为数据源指定唯一标识
        sourceBean.setPoolSize(5);
        sourceBean.setTestQuery("SELECT 1");
        sourceBean.setUniqueResourceName("db1");
        return sourceBean;
    }

    /**
     * 创建支持 XA 事务的 Atomikos 数据源 mydbtwo
     */
    @Bean
    public DataSource dataSourceTwo(DataSource druidDataSourceTwo) {
        AtomikosDataSourceBean sourceBean = new AtomikosDataSourceBean();
        sourceBean.setXaDataSource((DruidXADataSource) druidDataSourceTwo);
        sourceBean.setPoolSize(5);
        sourceBean.setTestQuery("SELECT 1");
        sourceBean.setUniqueResourceName("db2");
        return sourceBean;
    }


    /**
     * @param dataSourceOne 数据源 mydbone
     * @return 数据源 mydbone 的会话工厂
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryOne(DataSource dataSourceOne)
            throws Exception {
        return createSqlSessionFactory(dataSourceOne);
    }


    /**
     * @param dataSourceTwo 数据源 mydbtwo
     * @return 数据源 mydbtwo 的会话工厂
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryTwo(DataSource dataSourceTwo)
            throws Exception {
        return createSqlSessionFactory(dataSourceTwo);
    }


    /***
     * sqlSessionTemplate 与 Spring 事务管理一起使用，以确保使用的实际 SqlSession 是与当前 Spring 事务关联的,
     * 此外它还管理会话生命周期，包括根据 Spring 事务配置根据需要关闭，提交或回滚会话
     * @param sqlSessionFactoryOne 数据源 mydbone
     * @param sqlSessionFactoryTwo 数据源 mydbtwo
     */
    @Bean
    public CustomSqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactoryOne, SqlSessionFactory sqlSessionFactoryTwo) {
        Map<Object, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
        sqlSessionFactoryMap.put(DataSourceNames.ONE, sqlSessionFactoryOne);
        sqlSessionFactoryMap.put(DataSourceNames.TWO, sqlSessionFactoryTwo);
        CustomSqlSessionTemplate customSqlSessionTemplate = new CustomSqlSessionTemplate(sqlSessionFactoryOne);
        customSqlSessionTemplate.setTargetSqlSessionFactories(sqlSessionFactoryMap);
        return customSqlSessionTemplate;
    }

    /***
     * 自定义会话工厂
     * @param dataSource 数据源
     * @return :自定义的会话工厂
     */
    private SqlSessionFactory createSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        //配置驼峰命名
        configuration.setMapUnderscoreToCamelCase(true);
        //配置sql日志
        configuration.setLogImpl(StdOutImpl.class);
        factoryBean.setConfiguration(configuration);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //配置读取mapper.xml路径
        factoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
        return factoryBean.getObject();
    }

}
