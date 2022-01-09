package com.kenshine.basic._08_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 21:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Test01_Base {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/jdbc?characterEncoding=utf8&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true";
    public static final String USER = "root";
    public static final String PASSWORD = "zjx123456";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        //4.结果集ResultSet
        ResultSet rs = stmt.executeQuery("SELECT id,`name`,age FROM `user`");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("name")+" 年龄："+rs.getInt("age"));
        }

    }
}
