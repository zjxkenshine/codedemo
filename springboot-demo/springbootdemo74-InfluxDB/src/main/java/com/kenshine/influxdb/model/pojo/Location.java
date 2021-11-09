package com.kenshine.influxdb.model.pojo;

import com.kenshine.influxdb.annotation.Tag;
import lombok.Data;
import org.influxdb.annotation.Measurement;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:40
 * @description：地点
 * @modified By：
 * @version: $
 */
@Data
// 表名
@Measurement(name = "KENSHINE")
public class Location {
    /**
     * 时间
     */
    private String time;

    /**
     * 索引
     */
    @Tag
    private String belongId;

    /**
     * 地址
     */
    private String host;

    /**
     * 列名
     */
    private String ld;

    /**
     * 列名
     */
    private String ln;

    /**
     * 列名
     */
    private String max;

    /**
     * 列名
     */
    private String name;

    /**
     * 列名
     */
    private String st;

    /**
     * 值
     */
    private String value;
}
