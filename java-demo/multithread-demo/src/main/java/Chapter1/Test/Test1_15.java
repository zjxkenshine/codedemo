package Chapter1.Test;

import Chapter1.Thread.Thread1_15;

public class Test1_15 {
	//线程停止：Thread.interrupt()停止标记，无法停止线程
	public static void main(String[] args) {
		try{
			Thread1_15 thread=new Thread1_15();
			thread.start();
			Thread.sleep(10);
			thread.interrupt();          //仅做停止标记，并不停止线程
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		
	}

}
