package Chapter2.Test;

import Chapter2.Object.Object2_16_2;
import Chapter2.Thread.Thread2_16_2A;
import Chapter2.Thread.Thread2_16_2B;

public class Test2_16_2 {
	//synchronized(任意非this对象x)解决脏读问题
	
	/**1.由于线程执行方法的顺序不确定，所以当A和B两个线程执行带有分支判断的方法时，
	 * 	   会出现逻辑上的错误，会出现脏读
	 * 
	 * 2.解决方法：同步化
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Object2_16_2 obj=new Object2_16_2();
		Thread2_16_2A thread1=new Thread2_16_2A(obj);
		thread1.start();
		Thread2_16_2B thread2=new Thread2_16_2B(obj);
		thread2.start();
		Thread.sleep(3000);
		System.out.println("listSize="+obj.getSize());     //size>2则出现脏读
	}

}
