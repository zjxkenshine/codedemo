package com.kenshine.jta.config;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 10:15
 * @description：上下文
 * @modified By：
 * @version: $
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDataSourceKey(String dbName) {
        contextHolder.set(dbName);
    }

    // 获取数据源名
    public static String getDataSourceKey() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

}
