package Chapter2.Test;

import Chapter2.Object.Object2_15_1;
import Chapter2.Thread.Thread2_15_1A;
import Chapter2.Thread.Thread2_15_1B;

public class Test2_15_1 {
	//将任意非this对象作为【对象监视器】
	
	/**1.多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时
	 * 	 调用效果是按顺序进行，也就是同步的，阻塞的
	 * 
	 * 2.java还支持对"任意对象"作为"对象监视器"来实现同步的功能，大多是实例变量或方法的参数
	 * 	 使用格式为synchronized(非this对象x)
	 * 
	 * 3.synchronized(非this对象x)同步代码块的作用：
	 * 	 对同一对象其他synchronized(非this对象x)同步代码块阻塞
	 *  同一时间只有一个线程能执行同一对象的synchronized(非this对象x)同步代码
	 *  
	 * 4.synchronized(非this对象x)同步代码块优点：
	 *   与同一对象中的同步方法或synchronized(this)方法异步，不与其他this同步代码块争抢锁
	 *   锁的不是对象
	 */
	
	public static void main(String[] args) {
		
		Object2_15_1 obj=new Object2_15_1();
		Thread2_15_1A thread1=new Thread2_15_1A(obj);
		thread1.setName("a");
		thread1.start();
		Thread2_15_1B thread2=new Thread2_15_1B(obj);
		thread2.setName("b");
		thread2.start();
		
	}

}
