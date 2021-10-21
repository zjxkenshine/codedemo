package com.kenshine.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:11
 * @description：db2数据源配置
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
