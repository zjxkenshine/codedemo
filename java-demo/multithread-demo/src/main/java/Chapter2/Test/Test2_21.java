package Chapter2.Test;

import Chapter2.Object.Object2_21;
import Chapter2.Thread.Thread2_21A;
import Chapter2.Thread.Thread2_21B;

public class Test2_21 {
	//synchronized(class)´úÂë¿é
	

	/**
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_21 obj1=new Object2_21();
		Object2_21 obj2=new Object2_21();      
		Thread2_21A a=new Thread2_21A(obj1);
		a.setName("AAA");
		a.start();
		Thread2_21B b=new Thread2_21B(obj2);
		b.setName("BBB");
		b.start();
		
	}
}