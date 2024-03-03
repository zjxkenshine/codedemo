package Chapter7.Test;

import Chapter7.Thread.Thread7_03A;
import Chapter7.Thread.Thread7_03B;

public class Test7_03 {
	//验证BLOCKED状态
	
	/**
	 * BOCKED状态出现在某一个线程等待锁的时候
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		Thread7_03A t1=new Thread7_03A();
		t1.setName("AAA");
		t1.start();
		Thread.sleep(100);
		Thread7_03B t2=new Thread7_03B();
		t2.setName("BBB");
		t2.start();
		Thread.sleep(100);        //去掉这一行状态变为Runnable
		System.out.println("main方法中的t2的状态："+t2.getState());
		Thread.sleep(5000);
		System.out.println("main方法中的t1的状态："+t1.getState());
	}

}
