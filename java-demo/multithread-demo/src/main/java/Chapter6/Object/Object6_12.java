package Chapter6.Object;

import java.sql.Connection;
import java.sql.DriverManager;

public enum Object6_12 {
	//使用enum枚举数据类型实现单例模式
	
	connectionFactory;
	private Connection conn;
	
	private Object6_12(){
		try{
			System.out.println("调用了Object6_12的构造");
			String url="jdbc:mysql://localhost:3306/employee?characterEncoding=utf8&useSSL=true";
			String username="root";
			String PASSWORD = "zjx1754294529";
			String diver="com.mysql.jdbc.Driver";
			Class.forName(diver);
			conn=DriverManager.getConnection(url,username,PASSWORD);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection getcon(){
		return conn;
	}
	

}
