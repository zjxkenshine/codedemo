package Chapter1.Test;

import Chapter1.Thread.Thread1_11;

public class Test1_11 {
	//isAlive()方法：判断线程是否处于活动状态(已启动且尚未终止)
	public static void main(String[] args) throws InterruptedException {
		Thread1_11 thread=new Thread1_11();
		System.out.println("begin =="+thread.isAlive());    //false
		thread.start();
	//	Thread.sleep(1000);					//休眠1秒
		System.out.println("end =="+thread.isAlive());  //若不休眠，则值不确定
	}
}
