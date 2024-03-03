package Chapter2.Test;

import Chapter2.Thread.Thread2_33;

public class Test2_33 {
	//使用原子类对i++进行操作
	
	/**1.除了i++时使用synchronized关键字实现同步外，还可以用AtomicInteger原子类进行实现
	 * 
	 * 2.原子操作是不可分割的整体没有其他线程能中断或检查正在原子操作中的变量。
	 * 	 一个原子类型就是一个原子操作的可用类型，它可以在没有锁的情况下做到线程安全
	 * 
	 */
	
	public static void main(String[] args) {
		Thread2_33 thread=new Thread2_33();
		Thread t1=new Thread(thread);
		t1.start();
		Thread t2=new Thread(thread);
		t2.start();
		Thread t3=new Thread(thread);
		t3.start();
		Thread t4=new Thread(thread);
		t4.start();
	}
	
}
