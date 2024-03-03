package Chapter2.Test;

import Chapter2.Object.Object2_13;
import Chapter2.Thread.Thread2_13A;
import Chapter2.Thread.Thread2_13B;
import Chapter2.Thread.Thread2_13C;

public class Test2_13 {
	//synchronized代码块间的同步性
	
	/**当一个线程访问object的一个synchronized(this)同步代码块时，
	 * 其他线程对同一个object中所有其他synchronized(this)同步代码块将被阻塞
	 * 说明synchronized使用的【对象监视器】是同一个
	 * 
	 * synchronized(this)代码块（方法A,B）同样会阻塞synchronized方法（方法C）
	 */
	
	public static void main(String[] args) {
		Object2_13 obj=new Object2_13();
		Thread2_13A a=new Thread2_13A(obj);
		a.start();
		Thread2_13B b=new Thread2_13B(obj);
		b.start();
		Thread2_13C c=new Thread2_13C(obj);
		c.start();
	}

}
