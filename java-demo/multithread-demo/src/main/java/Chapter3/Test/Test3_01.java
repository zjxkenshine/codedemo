package Chapter3.Test;

import Chapter3.Object.Object3_01;
import Chapter3.Thread.Thread3_01A;
import Chapter3.Thread.Thread3_01B;

public class Test3_01 {
	//不使用等待/通知机制实现线程通信
	
	/**1.线程与线程之间不是独立的个体，他们彼此之间可以互相通信和协作
	 * 
	 * 2.本例用sleep和死循环结合来实现通信。
	 * 
	 * 3.弊端：
	 *  a.虽然实现了通信，但ThreadB不断通过while循环来检测某一个条件，这样会造成cpu浪费
	 *  b.轮询时间间隔小，更浪费cpu资源；轮询时间间隔太大，有可能会取到意想不到的数据
	 *  
	 *  4.更有效率的方法实现多个线程间通信：等待/通知机制
	 *  
	 *  5.多个线程访问同一个变量实现线程通信不是"等待/通知"机制
	 * 
	 */
	
	public static void main(String[] args) {
		Object3_01 obj=new Object3_01();
		Thread3_01A thread1=new Thread3_01A(obj);
		thread1.setName("A");
		thread1.start();
		Thread3_01B thread2=new Thread3_01B(obj);
		thread2.setName("B");
		thread2.start();
	}

}
