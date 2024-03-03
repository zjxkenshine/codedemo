package Chapter1.Test;

import Chapter1.Thread.Thread1_29_1;
import Chapter1.Thread.Thread1_29_2;

public class Test1_29 {
	//线程优先级高运行得快
	
	public static void main(String[] args) {
		try{
			Thread1_29_1 a=new Thread1_29_1();
			a.setPriority(Thread.NORM_PRIORITY-3); //2
			a.start();
			Thread1_29_2 b=new Thread1_29_2();
			b.setPriority(Thread.NORM_PRIORITY+3);  //8
			b.start();
			Thread.sleep(2000);
			a.stop();
			b.stop();
			System.out.println("a="+a.getCount());
			System.out.println("b="+b.getCount());          //b比a快
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
