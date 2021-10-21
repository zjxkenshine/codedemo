package com.kenshine.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:20
 * @description：动态切换数据源
 * @modified By：
 * @version: $
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceType.getDataSourceType();
    }

}
