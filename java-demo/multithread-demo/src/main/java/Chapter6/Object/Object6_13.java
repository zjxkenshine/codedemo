package Chapter6.Object;

import java.sql.Connection;
import java.sql.DriverManager;

public class Object6_13 {
	//完善使用enum枚举数据类型实现单例模式
	
	//类中包含一个枚举类
	
public enum mySingleton{
	
	connectionFactory;
	private Connection conn;
	
	private mySingleton(){
		try{
			System.out.println("调用了Object6_12的构造");
			String url="jdbc:mysql://localhost:3306/employee?characterEncoding=utf8&useSSL=true";
			String username="root";
			String PASSWORD = "******";
			String diver="com.mysql.jdbc.Driver";
			Class.forName(diver);
			conn=DriverManager.getConnection(url,username,PASSWORD);
			
		}catch (Exception e){
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Connection get(){
		return conn;
	}
}
	
	public static Connection getcon(){
		return mySingleton.connectionFactory.get();
	}

}
