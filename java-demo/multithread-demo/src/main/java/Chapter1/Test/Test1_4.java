package Chapter1.Test;

import Chapter1.Thread.runnable1_4;

public class Test1_4 {
	//线程的另一种实现方式：实现runnable接口
	//Thread类也是通过实现该接口
	
	public static void main(String[] args) {
		
		runnable1_4 run=new runnable1_4();
		Thread thread=new Thread(run);
		thread.start();
		System.out.println("main线程结束！");
	}

}
