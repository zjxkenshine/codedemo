package Chapter6.Object;

import java.sql.Connection;
import java.sql.DriverManager;

public class Object6_13 {
	//����ʹ��enumö����������ʵ�ֵ���ģʽ
	
	//���а���һ��ö����
	
public enum mySingleton{
	
	connectionFactory;
	private Connection conn;
	
	private mySingleton(){
		try{
			System.out.println("������Object6_12�Ĺ���");
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
