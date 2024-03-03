package Chapter4.Test;

import Chapter4.Object.Service4_04;
import Chapter4.Thread.Thread4_04;

public class Test4_04 {
	//正确使用Condition实现等待/通知
	
	/**Object类中的wait()方法相当于Condition类中的await()方法
	 * Object类中的wait(long timeout)方法相当于Condition类中的await(long time,TimeUnit unit)方法
	 * Object类中的notify()方法相当于Condition类中的signal()方法
	 * Object类中的notifyAll()方法相当于Condition类中的signalAll()方法
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Service4_04 ser=new Service4_04();
		Thread4_04 th=new Thread4_04(ser);
		th.start();
		Thread.sleep(3000);
		ser.signal();
	}

}
