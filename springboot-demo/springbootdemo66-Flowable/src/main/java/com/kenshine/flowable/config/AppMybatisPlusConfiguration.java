package com.kenshine.flowable.config;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/7 21:46
 * @description：配置实现
 * @modified By：
 * @version: $
 *
 * mybatis-plus与flowable冲突，没有效果
 */


//@MapperScan(basePackages = {
//        "com.kenshine.flowable.mapper"
//},
//        sqlSessionTemplateRef = "appSqlSessionTemplate",
//        sqlSessionFactoryRef = "appSqlSessionFactory"
//)
//@EnableConfigurationProperties(MybatisPlusProperties.class)
//@Configuration
public class AppMybatisPlusConfiguration extends AbstractMybatisPlusConfiguration{
//
//    @Bean(name = "appSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource,
//                                                   MybatisPlusProperties properties,
//                                                   ResourceLoader resourceLoader,
//                                                   ApplicationContext applicationContext) throws Exception {
//        return getSqlSessionFactory(dataSource,
//                properties,
//                resourceLoader,
//                null,
//                null,
//                applicationContext);
//    }
//
//    @Bean(name = "appSqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(MybatisPlusProperties properties,
//                                                 @Qualifier("appSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//        return getSqlSessionTemplate(sqlSessionFactory, properties);
//    }
}
