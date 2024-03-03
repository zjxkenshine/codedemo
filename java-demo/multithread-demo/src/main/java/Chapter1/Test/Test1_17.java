package Chapter1.Test;

import Chapter1.Thread.Thread1_17;

public class Test1_17 {
	//this.isInterrupted():非静态方法，测试线程对象（非当前线程）是否中断，但不清除中断状态标记
	public static void main(String[] args) {
		try{
			Thread1_17 thread=new Thread1_17();
			thread.setName("A");
			thread.start();
			Thread.sleep(10);
			thread.interrupt();
			System.out.println(thread.getName()+"是否停止1？="+thread.isInterrupted());    
			System.out.println(thread.getName()+"是否停止2？="+thread.isInterrupted());
			//不清除thread的中断标记，但是线程会继续执行
		}catch(InterruptedException e){
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
