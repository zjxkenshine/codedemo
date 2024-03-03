package Chapter2.Test;

import Chapter2.Object.Object2_10;
import Chapter2.Thread.Thread2_10A;
import Chapter2.Thread.Thread2_10B;

public class Test2_10 {
	//synchronized(this)同步代码块的使用
	
	/**两个并非线程访问同一对象的synchronized(this)同步代码块时，一段时间只有一个线程被执行，
	 * 另一个线程必须等待当前线程执行完这个代码块才能执行该代码块
	 * 
	 */
	
	public static void main(String[] args) {
		Object2_10 obj=new Object2_10();
		Thread2_10A a=new Thread2_10A(obj);
		a.setName("a");
		a.start();
		Thread2_10B b=new Thread2_10B(obj);
		b.setName("b");
		b.start();
	}

}
