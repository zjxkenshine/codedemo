package com.kenshine.influxdb.dao;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:43
 * @description：测试Dao
 * @modified By：
 * @version: $
 */
public interface InfluxDao {
    /**
     * 测试连接是否正常
     * @return
     */
    Boolean ping();

    /**
     * 创建数据库
     * 说明：方法参数没有指定时，默认使用配置文件中数据库名
     */
    void createDataBase(String... dataBaseName);

    /**
     * 删除数据库
     * 说明：方法参数没有指定时，默认使用配置文件中数据库名
     */
    void deleteDataBase(String... dataBaseName);

    /**
     * 插入数据
     * 支持：对象,集合(集合时对应实体类必须使用@Tag注解指定一个字段)
     *
     * @param object 数据
     */
    <T> void insert(T object);

    /**
     * 查询数据
     *
     * @param sql
     * @return
     */
    <T> List<T> query(Class<T> clazz, String sql);
}
