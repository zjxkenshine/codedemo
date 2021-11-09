package com.kenshine.ureport.config;

import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 14:25
 * @description：报表配置
 * @modified By：
 * @version: $
 */
@ImportResource("classpath:ureport-console-context.xml")//不加项目能够启动但是会导致加载数据源报错或加载不了
@Configuration
public class UreportConfig implements BuildinDatasource {
    @Resource
    DataSource dataSource;

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     *  定义ureport的启动servlet
     */
    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean ureportServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new UReportServlet());
        servletRegistrationBean.addUrlMappings("/ureport/*");
        return servletRegistrationBean;
    }

    @Override
    public String name() {
        return "myUReportDatasource";
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Ureport 数据源 获取连接失败！");
            e.printStackTrace();
        }
        return null;
    }

}
