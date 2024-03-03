package Chapter2.Test;

import Chapter2.Object.Object2_23;
import Chapter2.Thread.Thread2_23A;
import Chapter2.Thread.Thread2_23B;

public class Test2_23 {
	//同步synchronized方法无限等待与解决  
	
	/**
	 * 同步方法容易造成死循环,得不到运行机会
	 */
	
	public static void main(String[] args) {
		Object2_23 obj=new Object2_23();
		Thread2_23A a=new Thread2_23A(obj);
		a.start();
		Thread2_23B b=new Thread2_23B(obj);
		b.start();
	}

}
