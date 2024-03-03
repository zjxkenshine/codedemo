package Chapter1.Test;

import Chapter1.Thread.Thread1_13;

public class Test1_13 {
//sleep()方法，使this.currentThread()(正在执行的线程)休眠指定毫秒
	public static void main(String[] args) {
		Thread1_13 thread=new Thread1_13();
		System.out.println("begin="+System.currentTimeMillis());
	//	thread.run();              //同步
		thread.start();             //异步
		System.out.println("end="+System.currentTimeMillis());
	}
}
