package Chapter2.Test;

import Chapter2.Object.Object2_16_1;
import Chapter2.Thread.Thread2_16_1A;
import Chapter2.Thread.Thread2_16_1B;

public class Test2_16_1 {
	//synchronized(任意非this对象x)解决脏读问题
	
	/**
	 * 多个线程调用同一个方法是随机的，例子
	 * 
	 * A线程与B线程的执行是异步的，无规律的
	 */
	
	public static void main(String[] args) {
		Object2_16_1 obj=new Object2_16_1();
		Thread2_16_1A thread1=new Thread2_16_1A(obj);
		thread1.setName("AAA");
		thread1.start();
		Thread2_16_1B thread2=new Thread2_16_1B(obj);
		thread2.setName("BBB");
		thread2.start();
	}

}
