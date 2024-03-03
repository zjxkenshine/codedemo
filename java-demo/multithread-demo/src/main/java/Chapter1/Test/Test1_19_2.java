package Chapter1.Test;

import Chapter1.Thread.Thread1_19_2;

public class Test1_19_2{
	//在interrput()状态下使用sleep()的情况
	//抛出异常从而停止线程（推荐使用）
	
	public static void main(String[] args) {
		Thread1_19_2 thread =new Thread1_19_2();
		thread.start();
		thread.interrupt();
		System.out.println("end!");
	}
	
	
}
