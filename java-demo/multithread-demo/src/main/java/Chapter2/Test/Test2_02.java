package Chapter2.Test;


import Chapter2.Object.Object2_02;

import Chapter2.Thread.Thread2_02A;
import Chapter2.Thread.Thread2_02B;

public class Test2_02 {
	//实例变量非线程安全

	
	public static void main(String[] args) {
		Object2_02 obj=new Object2_02();
		Thread2_02A thread1=new Thread2_02A(obj);
		thread1.start();
		Thread2_02B thread2=new Thread2_02B(obj);
		thread2.start(); 
		
	}
}
