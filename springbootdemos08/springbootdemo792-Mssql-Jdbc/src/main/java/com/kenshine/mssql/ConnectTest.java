package com.kenshine.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author by kenshine
 * @Classname ConnectTest
 * @Description 连接测试
 * @Date 2024-04-28 13:41
 * @modified By：
 * @version: 1.0$
 */
public class ConnectTest {
    public static void main(String[] args) throws ClassNotFoundException {
            String url="jdbc:sqlserver://192.168.0.249:1433;DatabaseName=PLM;SelectMethod=cursor;encrypt=false;rewriteBatchedStatements=true";
            String user="sa";
            String pwd="server!@#$%6";
            String conTime = "";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try {
                // 1.获取开始时间
                long startTime = System.currentTimeMillis();

                // 2. 建立数据库连接
                Connection connection = DriverManager.getConnection(url, user, pwd);

                System.out.println("数据库连接成功");

                // 3.获取传输器
                Statement st = connection.createStatement();

                // 4.通过传输器发送SQL到服务器执行并且返回执行结果
                String sql = "SELECT * FROM plm.dbo.BOM_006;";

                ResultSet rs = st.executeQuery(sql);
                // 5.数据处理
                while (rs.next()) {
                    int id = rs.getInt("TempletTypeID");
                    String name = rs.getString("templetTypeName");
                    System.out.println(id + ":" + name);
                }

                // 6. 获取结束时间，并计算连接数据库，执行SQL语句时间
                long endTime = System.currentTimeMillis();
                //获取结束时间
                conTime = "程序运行时间：" + (endTime - startTime) + "ms";
                //输出程序运行时间
                System.out.println(conTime);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }
}
