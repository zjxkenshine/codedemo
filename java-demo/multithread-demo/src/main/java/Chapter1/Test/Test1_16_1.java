package Chapter1.Test;

import Chapter1.Thread.Thread1_16;

public class Test1_16_1 {
	//this.interrupted():判断当前线程是否中断，执行后清除中断标记
	//当前标记指的是运行该方法的线程，与前缀无关
	
	public static void main(String[] args) {
		try{
			Thread1_16 thread=new Thread1_16();
			thread.start();
			Thread.sleep(10);
			thread.interrupt();
			System.out.println(Thread.currentThread().getName()+"是否停止？="+thread.interrupted());    //由main线程调用
			System.out.println(Thread.currentThread().getName()+"是否停止？="+thread.interrupted());
			
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
	}

}
