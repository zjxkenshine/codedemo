package Chapter2.Test;

import Chapter2.Object.Object2_22_1;
import Chapter2.Thread.Thread2_22_1A;
import Chapter2.Thread.Thread2_22_1B;

public class Test2_22_1 {
	// 【String常量池的特性】给synchronized(String)带来的例外
	
	/**
	 * 1.JVM中具有String常量池缓存的功能，将synchronized(String)同步语句块与String联合使用时，会出现意外情况
	 * 
	 * 2.B与A的监视器都是AAA,b永远得不到锁
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_22_1 obj=new Object2_22_1();
		Thread2_22_1A a=new Thread2_22_1A(obj);
		a.setName("A");
		a.start();
		Thread2_22_1B b=new Thread2_22_1B(obj);
		b.setName("B");
		b.start();
	}

}
