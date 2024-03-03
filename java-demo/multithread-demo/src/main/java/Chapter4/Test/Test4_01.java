package Chapter4.Test;

import Chapter4.Object.Service4_01;
import Chapter4.Thread.Thread4_01;

public class Test4_01 {
	//使用ReentrantLock实现同步：测试1
	
	/**1.ReentrantLock类：
	 *   在java多线程中synchronized关键字来实现线程之间的同步互斥，
	 *   JDK1.5新增ReentrantLock类也能达到同样的效果，并且在扩展功能上更加强大;
	 *   如：具有嗅探锁的，多路分支通知等功能，而且在使用上也比synchronized更加灵活
	 * 
	 * 
	 * 2.例子可以看到分组打印的，因为当前线程已经持有锁，但是线程之间的打印顺序是随机的
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		Service4_01 ser=new Service4_01();
		Thread4_01 t1=new Thread4_01(ser);
		Thread4_01 t2=new Thread4_01(ser);
		Thread4_01 t3=new Thread4_01(ser);
		Thread4_01 t4=new Thread4_01(ser);
		Thread4_01 t5=new Thread4_01(ser);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
