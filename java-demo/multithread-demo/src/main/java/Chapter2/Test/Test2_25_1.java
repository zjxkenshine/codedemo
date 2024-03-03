package Chapter2.Test;

import Chapter2.Object.Object2_25_1;
import Chapter2.Object.Object2_25_1.PrivateClass;

public class Test2_25_1 {
	//内置类
	
	
	
	public static void main(String[] args) {
		Object2_25_1 obj=new Object2_25_1();
		obj.setUsername("username");
		obj.setPassword("pwd");
		System.out.println(obj.getUsername()+" "+obj.getPassword());
		
		PrivateClass prcla= obj.new PrivateClass();          //实例化内置类对象
		
		prcla.setAge("age");
		prcla.setAddress("address");
		System.out.println(prcla.getAddress()+" "+prcla.getAge());
	}
	
	
	
}