package Chapter2.Test;

import Chapter2.Object.Object2_28_1;
import Chapter2.Thread.Thread2_28_1A;
import Chapter2.Thread.Thread2_28_1B;

public class Test2_28_1 {
	//锁对象的改变
	
	/**
	 * 多个线程同时持有相同的锁对象，则这些线程同步；
	 * 如果分别持有锁对象，则这些线程异步
	 * @throws InterruptedException 
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Object2_28_1 obj=new Object2_28_1();
		Thread2_28_1A a=new Thread2_28_1A(obj);
		a.setName("aaa");
		Thread2_28_1B b=new Thread2_28_1B(obj);
		b.setName("bbb");
		a.start();
		Thread.sleep(50);           //不加这句同步
		b.start();
	}
	

}
