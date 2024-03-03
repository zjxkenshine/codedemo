package Chapter2.Test;

import Chapter2.Object.Object2_01;
import Chapter2.Thread.Thread2_01A;
import Chapter2.Thread.Thread2_01B;

public class Test2_01 {
	//方法内的变量为线程安全
	/**1.非线程安全会在多个线程对 同一个 对象中的实例变量进行并发访问时产生
	 * 	   产生的后果就是脏读
	 * 
	 * 2.非线程安全存在于实例变量中，方法内部的私有变量，则不存在非线程安全
	 * 
	 * 3.方法内部永远线程安全
	 */
	public static void main(String[] args) {
		Object2_01 obj=new Object2_01();
		Thread2_01A thread1=new Thread2_01A(obj);
		thread1.start();
		Thread2_01B thread2=new Thread2_01B(obj);
		thread2.start(); 
	}

}
