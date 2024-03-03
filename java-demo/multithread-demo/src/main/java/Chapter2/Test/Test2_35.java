package Chapter2.Test;

import Chapter2.Object.Object2_35;
import Chapter2.Thread.Thread2_35A;
import Chapter2.Thread.Thread2_35B;

public class Test2_35 {
	//synchronized代码块有volatile同步功能          
	
	/**
	 * 1.关键字synchronized可以使多个线程访问同一个资源具有同步性，
	 * 	   而且它还具有将私有变量与巩固内存中变量同步的功能
	 * 
	 * 2.synchronized有两个特性：可视性，互斥性
	 * 
	 * 3.关键字synchronized可以保证在同一个时刻，只有一个线程执行某一个方法或代码块，
	 * 	 还可以保证进入同步方法或者同步代码块的每个线程，都看到由一个锁保护之前的所有修改效果
	 * 
	 * 4.外练互斥，内修可见
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Object2_35 obj=new Object2_35();
		Thread2_35A a=new Thread2_35A(obj);
		a.start();
		Thread.sleep(1000);
		Thread2_35B b=new Thread2_35B(obj);
		b.start();
		System.out.println("已发出停止指令");
		
	}
	

}
