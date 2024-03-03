package Chapter2.Test;

import Chapter2.Object.Object2_04_2;
import Chapter2.Thread.Thread2_04_2A;
import Chapter2.Thread.Thread2_04_2B;

public class Test2_04_2 {
	//synchronized方法锁的是这个对象而非方法
	
	/**1.A线程先持有object对象的lock锁，B线程可以以异步方式调用object对象中的非synchronized类型方法
	 * 
	 * 2.A线程先持有object对象的lock锁，B线程如果在这时调用object对象中synchronized类型方法
	 * 	 则需要等待，也就是同步。
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_04_2 obj=new Object2_04_2();
		Thread2_04_2A a=new Thread2_04_2A(obj);
		a.setName("a");
		Thread2_04_2B b=new Thread2_04_2B(obj);
		b.setName("b");
		a.start();
		b.start();
	}
	
}
