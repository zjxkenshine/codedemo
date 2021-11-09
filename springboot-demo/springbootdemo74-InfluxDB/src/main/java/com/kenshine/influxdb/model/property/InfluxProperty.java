package com.kenshine.influxdb.model.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:41
 * @description：时序数据库参数
 * @modified By：
 * @version: $
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.influx")
public class InfluxProperty {

    /**
     * 数据库名
     */
    private String dataBaseName;
}
