package com.kenshine.datasource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/21 11:22
 * @description：Aop切面
 * @modified By：
 * @version: $
 *
 * 重点就是这个
 */
@Aspect
@Component
@Slf4j
public class DataSourceAop {


    @Before("execution(* com.kenshine.service.impl.GoodsServiceImpl.*(..))")
    public void setDataSource01() {
        log.warn("db01商品数据源");
        DataSourceType.setDataSourceType(DataSourceType.SourceType.DS_SHOP);
    }

    @Before("execution(* com.kenshine.service.impl.UserServiceImpl.*(..))")
    public void setDataSource02() {
        log.warn("db02用户数据源");
        DataSourceType.setDataSourceType(DataSourceType.SourceType.DS_USER);
    }


}
