package com.kenshine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 10:10
 * @description：数据库2配置
 * @modified By：
 * @version: $
 */

@ConfigurationProperties(prefix = "spring.datasource.ds2")
@Component("ds2Properties")
@Data
public class Ds2Properties {

    private String url;

    private String username;

    private String password;

    private String driverClassName;
}
