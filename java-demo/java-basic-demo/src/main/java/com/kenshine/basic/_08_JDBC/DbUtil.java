package com.kenshine.basic._08_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 21:48
 * @description： DB工具类
 * @modified By：
 * @version: $
 */
public class DbUtil {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PASSWORD = "zjx123456";
    private static Connection conn = null;
    static{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
