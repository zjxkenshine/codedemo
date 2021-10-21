package com.kenshine.datasource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:19
 * @description：数据源类型
 * @modified By：
 * @version: $
 *
 * 利用ThreadLocal确保线程安全性，每个线程之间不会相互影响
 */
@Slf4j
public class DataSourceType {

    public enum SourceType {
        /**
         * 用户数据源
         */
        DS_USER,
        /**
         * 商品数据源
         */
        DS_SHOP
    }

    /**
     * 使用ThreadLocal保证线程安全
     */
    private static final ThreadLocal<SourceType> TYPES = new ThreadLocal<>();

    /**
     * 往当前线程里设置数据源类型
     */
    public static void setDataSourceType(SourceType dataSourceType) {
        if (dataSourceType == null) {
            throw new NullPointerException();
        }
        log.warn("[设置当前数据源为]：" + dataSourceType);
        TYPES.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     */
    public static SourceType getDataSourceType() {
        SourceType dataSourceType = TYPES.get() == null ? SourceType.DS_USER : TYPES.get();
        log.warn("[当前数据源的类型为]：" + dataSourceType);
        return dataSourceType;
    }

    /**
     * 清空数据类型
     */
    public static void removeDataSourceType() {
        TYPES.remove();
    }

}
