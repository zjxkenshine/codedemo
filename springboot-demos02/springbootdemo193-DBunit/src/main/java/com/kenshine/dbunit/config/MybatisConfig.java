package com.kenshine.dbunit.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 9:05
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
//com.kenshine.**.mapper
@MapperScan(basePackages={"com.kenshine.dbunit.mapper"})
public class MybatisConfig {
}
