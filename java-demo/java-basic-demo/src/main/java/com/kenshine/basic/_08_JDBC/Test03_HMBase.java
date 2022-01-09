package com.kenshine.basic._08_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/9 21:58
 * @description：黑马视频中的实现
 * @modified By：
 * @version: $
 *
    1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
    1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
    2.右键-->Add As Library
    2. 注册驱动
    3. 获取数据库连接对象 Connection
    4. 定义sql
    5. 获取执行sql语句的对象 Statement
    6. 执行sql，接受返回结果
    7. 处理结果
    8. 释放资源
 */
public class Test03_HMBase {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "zjx123456");
        //4.定义sql语句
        String sql = "update account set balance = 500 where id = 1";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
