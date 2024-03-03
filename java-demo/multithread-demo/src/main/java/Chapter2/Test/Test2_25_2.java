package Chapter2.Test;



import Chapter2.Object.Object2_25_2;
import Chapter2.Object.Object2_25_2.PrivateClass1;

public class Test2_25_2 {
	//静态内置类
	
	public static void main(String[] args) {
		Object2_25_2 obj=new Object2_25_2();
		obj.setUsername("user");
		obj.setPassword("pwd");
		System.out.println(obj.getUsername()+" "+obj.getPassword());
		
		PrivateClass1 prical=new PrivateClass1();         //静态内置类实例化
		
		prical.setAddress("ADD");
		prical.setAge("age");
		System.out.println(prical.getAge()+" "+prical.getAddress());
	}

}
