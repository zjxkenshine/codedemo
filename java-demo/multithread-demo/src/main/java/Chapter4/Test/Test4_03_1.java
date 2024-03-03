package Chapter4.Test;

import Chapter4.Object.Service4_03_1;
import Chapter4.Thread.Thread4_03_1;

public class Test4_03_1 {
	//使用Condition实现等待/通知：错误的用法及解决
	
	/**1.关键字synchronized与wait()和notify()/notifyAll()方法结合使用可以实现同样的功能，但是要借助于condition对象
	 * 
	 * 2.condition类是JDK5中出现的技术，使用它有更好的灵活性，比如实现多通路通知功能，
	 *   也就是在一个Lock对象里可以创建多个Condition(对象监视器)实例，线程对象可以注册在指定的Condition中
	 *   从而可以有选择性地进行通知线程，在调度线程上更加灵活。
	 *   
	 * 3.在使用notify/notifyAll方法进行通知时，被通知的线程却是由JVM随机选择的。
	 *   但是使用ReentrantLock结合Condition类可以实现选择性通知，这个功能是Condition默认提供的
	 *   
	 * 4.synchronize相当于整个Lock对象中只有单一的Condition对象，所有线程都注册在它一个对象身上。
	 *   线程开始notifyAll()时，需要通知所有等待的线程，没有选择功能，会出现很大的效率问题。
	 * 
	 */
	
	//本例子出错，原因是必须在调用await()方法前使用lock.lock获得同步监视器
	//修改后的例子为4_03_2
	public static void main(String[] args) {
		Service4_03_1 ser=new Service4_03_1();
		Thread4_03_1 t1=new Thread4_03_1(ser);
		t1.start();
	}
	
	
	
	

}
