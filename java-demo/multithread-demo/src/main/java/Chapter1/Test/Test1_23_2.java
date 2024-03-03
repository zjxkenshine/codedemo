package Chapter1.Test;

import Chapter1.Thread.Thread1_23_2;

public class Test1_23_2 {
	//suspend()与resume()缺点例子：独占同步锁
	
	public static void main(String[] args) {
		try{
			Thread1_23_2 thread =new Thread1_23_2();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			System.out.println("main end!");        //会被println是同步方法，会被thread独占
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
