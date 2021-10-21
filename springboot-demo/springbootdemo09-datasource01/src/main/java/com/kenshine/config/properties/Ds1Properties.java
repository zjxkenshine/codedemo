package com.kenshine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:09
 * @description：数据库1配置
 * @modified By：
 * @version: $
 */

@ConfigurationProperties(prefix = "spring.datasource.ds1")
@Component("ds1Properties")
@Data
public class Ds1Properties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;

}