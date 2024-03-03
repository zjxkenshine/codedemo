package Chapter4.Test;

import Chapter4.Object.Service4_17;
import Chapter4.Thread.Thread4_17A;
import Chapter4.Thread.Thread4_17B;

public class Test4_17 {
	//ReentrantReadWriteLock类的使用：【读读共享】
	
	/**1.类ReentranLock具有完全互斥排他的效果，同一时间只能有一个线程执行ReentrantLock.lock后面的程序
	 *   这样虽然可以保证实例变量的安全性，但是效率是非常低下的
	 *   
	 * 2.JDK提供了读写锁类ReentrantReadWriteLock来提高效率，在某些不需要操作实例变量的方法中，
	 *   完全可以使用读写锁来提升该方法的运行速度
	 *   
	 * 3.读写锁表示有两个锁：一个是读操作相关的锁，称为共享锁，另一个是写操作相关的锁也叫排他锁;
	 *   多个读锁之间不互斥，读写，写写，写读锁都会互斥。
	 *   
	 * 4.在没有线程进入写操作时，进行读操作的多个线程都可以获得读锁，而进行写操作的线程只有在获取写锁后才能进行写入操作。
	 *   即多个线程可以同时进行读操作，但是同一时间只允许一个线程进行写操作
	 */
	
	public static void main(String[] args) {
		final Service4_17 ser=new Service4_17();
		
		Thread4_17A a=new Thread4_17A(ser);
		a.setName("AAA");
		a.start();
		Thread4_17B b=new Thread4_17B(ser);
		b.setName("BBB");
		b.start();
	}

}
