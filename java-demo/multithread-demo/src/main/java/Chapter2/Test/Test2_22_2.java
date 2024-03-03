package Chapter2.Test;

import Chapter2.Object.Service2_22_2;
import Chapter2.Thread.Thread2_22_2A;
import Chapter2.Thread.Thread2_22_2B;

public class Test2_22_2 {
	//【String常量池的特性】给synchronized(String)带来的例外
	/**
	 * 在大多数情况下，同步synchronized代码块都不用String作为锁的对象，而改用其他，
	 * 比如new Object()实例化一个Object对象，但它并不放入缓存中
	 * 
	 */
	
	
	//不会出现同步现象
	public static void main(String[] args) {
		Service2_22_2 ser=new Service2_22_2();
		Thread2_22_2A a=new Thread2_22_2A(ser);
		a.setName("A");
		a.start();
		Thread2_22_2B b=new Thread2_22_2B(ser);
		b.setName("B");
		b.start();
	}

}
