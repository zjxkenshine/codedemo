package Chapter2.Test;

import Chapter2.Object.Object2_02;
import Chapter2.Thread.Thread2_02A;
import Chapter2.Thread.Thread2_02B;

public class Test2_03 {
	//多个对象会产生多个锁
	
	/**1.区别于Test2_02,多个对象会产生多个锁，异步(asychronized)执行
	 * 
	 * 2.同步(sychronized)执行前提是多个线程访问【同一个】对象
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_02 obj1=new Object2_02();        //不同的对象
		Object2_02 obj2=new Object2_02();
		Thread2_02A thread1=new Thread2_02A(obj1);
		thread1.start();
		Thread2_02B thread2=new Thread2_02B(obj2);
		thread2.start(); 
	}
	
}
