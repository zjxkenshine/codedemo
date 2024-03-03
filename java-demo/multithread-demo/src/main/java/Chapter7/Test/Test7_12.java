package Chapter7.Test;

import Chapter7.Thread.Thread7_12;

public class Test7_12 {
	//使线程具有有序性
	
	/**
	 * 正常情况下，线程在运行多个线程之间执行任务的时机是无序的。
	 * 可以通过改造代码的方式使它们的运行具有有序性
	 */
	
	public static void main(String[] args) {
		Object lock=new Object();
		Thread7_12 t1=new Thread7_12(lock, "A", 1);
		Thread7_12 t2=new Thread7_12(lock, "B", 2);
		Thread7_12 t3=new Thread7_12(lock, "C", 0);
		t1.start();
		t2.start();
		t3.start();
	}

}
