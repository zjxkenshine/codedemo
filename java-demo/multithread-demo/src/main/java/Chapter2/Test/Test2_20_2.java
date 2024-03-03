package Chapter2.Test;

import Chapter2.Thread.Thread2_20_2A;
import Chapter2.Thread.Thread2_20_2B;
import Chapter2.Thread.Thread2_20_2C;

public class Test2_20_2 {
	//静态同步synchronized方法2
	
	/**synchronized加到static静态方法上是给class类上锁，加到非static方法上锁的是对象
	 * 
	 * 方法A与方法C异步调用，一个持有对象锁，一个持有Class锁
	 */
	
	public static void main(String[] args) {
		Thread2_20_2A a=new Thread2_20_2A();
		a.setName("AAA");
		a.start();
		Thread2_20_2B b=new Thread2_20_2B();
		b.setName("BBB");
		b.start();
		Thread2_20_2C c=new Thread2_20_2C();
		c.setName("CCC");
		c.start();
	}

}
