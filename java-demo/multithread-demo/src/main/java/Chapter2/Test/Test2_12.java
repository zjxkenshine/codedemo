package Chapter2.Test;

import Chapter2.Object.Object2_12;
import Chapter2.Thread.Thread2_12A;
import Chapter2.Thread.Thread2_12B;

public class Test2_12 {
	//同步代码块一半同步一半异步
	
	/**在synchronized块中的代码同步执行，不在synchronized块中的代码异步执行
	 * 
	 * 同步代码块持有当前调用对象的锁(验证)
	 */
	
	public static void main(String[] args) {
		Object2_12 obj=new Object2_12();
		Thread2_12A thread1=new Thread2_12A(obj);
		thread1.start();
		Thread2_12B thread2=new Thread2_12B(obj);
		thread2.start();
	}
	

}
