package Chapter2.Test;

import Chapter2.Thread.Thread2_20_1A;
import Chapter2.Thread.Thread2_20_1B;

public class Test2_20_1 {
	//静态同步synchronized方法1
	
	/**关键字synchronized还可以应用在static静态方法上，对当前*.java文件【对应的Class类】进行持锁
	 * 
	 * 同步效果
	 */
	
	public static void main(String[] args) {
		Thread2_20_1A thread1=new Thread2_20_1A();
		thread1.setName("AAA");
		thread1.start();
		Thread2_20_1B thread2=new Thread2_20_1B();
		thread2.setName("BBB");
		thread2.start();
	}

}
