package Chapter1.Test;

import Chapter1.Thread.Thread1_26_1;

public class Test1_26 {
	//线程优先级的继承性
	/**使用setPriority()方法设置线程优先级1-10
	 * 
	 * jdk中的预定义常量：
	 * MIN_PRIORITY=1
	 * NORM_PRIORITY=5
	 * MAX_PRIORITY=10
	 * 
	 * 继承性：
	 * A线程启动B线程，则B线程优先级与A相同
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("main 的 priority="+Thread.currentThread().getPriority());
		//Thread.currentThread().setPriority(6);    //注释这一行
		System.out.println("main 的 priority="+Thread.currentThread().getPriority());
		Thread1_26_1 thread=new Thread1_26_1();
		thread.start();
	}

}
