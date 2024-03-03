package Chapter1.Test;

import Chapter1.Thread.Thread1_19_1;

public class Test1_19_1 {
	//在sleep()状态下使用interrput()的情况
	//抛出异常从而停止线程（推荐使用）
	
	public static void main(String[] args) {
		try{
			Thread1_19_1 thread=new Thread1_19_1();
			thread.start();
			Thread.sleep(200);
			thread.interrupt();
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
