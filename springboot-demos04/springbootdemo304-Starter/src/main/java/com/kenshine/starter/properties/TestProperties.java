package com.kenshine.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 16:16
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@ConfigurationProperties(prefix = "test.config")
public class TestProperties {
    //没有配置会使用该默认属性
    private String user="kenshine";

    private String password="123456";

    private String salt="DGEWVXSEDF";

}
