package com.kenshine.dbvisitor.util;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author by kenshine
 * @Classname DsUtils
 * @Description datasource工具类
 * @Date 2024-03-10 11:31
 * @modified By：
 * @version: 1.0$
 */
public class DsUtils {
    public static String MYSQL_JDBC_URL  = "jdbc:mysql://127.0.0.1:3306/springboot05?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=GMT%2B8";

    private static DataSource createDs(String driver, String url, String user, String password) throws SQLException {
        HikariDataSource druid = new HikariDataSource();
        druid.setJdbcUrl(url);
        druid.setDriverClassName(driver);
        druid.setUsername(user);
        druid.setPassword(password);
        druid.setMinimumIdle(5);
        druid.setMaximumPoolSize(12);
        druid.setMaxLifetime(1200000);
        druid.setAutoCommit(true);
        druid.setConnectionTimeout(20000);
        return druid;
    }

    public static Connection localMySql() throws SQLException {
        return DriverManager.getConnection(MYSQL_JDBC_URL, "root", "123456");
    }


    public static DataSource dsMySql() throws SQLException {
        return createDs("com.mysql.cj.jdbc.Driver", MYSQL_JDBC_URL, "root", "123456");
    }

}
