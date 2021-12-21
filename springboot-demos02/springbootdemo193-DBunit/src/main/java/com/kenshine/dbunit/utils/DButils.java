package com.kenshine.dbunit.utils;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 9:35
 * @description：
 * @modified By：
 * @version: $
 */
public class DButils {
    private static IDatabaseConnection conn;

    //通过dbUnit创建数据库连接
    public static IDatabaseConnection getDataBaseConnection() throws ClassNotFoundException, SQLException, DatabaseUnitException {
        if(conn==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection dbConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/db4", "root", "zjx123456");
            conn =new MySqlConnection(dbConn,"db4");
            return conn;
        }
        return conn;
    }

    //关闭数据库连接
    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conn=null;
    }
}
