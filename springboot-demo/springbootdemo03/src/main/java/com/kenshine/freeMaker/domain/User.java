package com.kenshine.freeMaker.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:12
 * @description：用户
 * @modified By：
 * @version: $
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "users")
@PropertySource(value = "classpath:/conf.properties")
public class User {

    private String name;

    private String desc;

}
