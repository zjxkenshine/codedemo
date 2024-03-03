package Chapter1.Test;

import Chapter1.Thread.Thread1_2;

public class Test1_2 {
	//线程的随机性测试
	//Cpu执行哪个线程具有不确定性
	public static void main(String[] args) {
		try{
			Thread1_2 thread=new Thread1_2();
			thread.setName("myThread");   //设置线程名
			thread.start();         //启动线程main
			
			//设置主线程动作与thread一致
			for(int i=0;i<10;i++){
				int time =(int)(Math.random()*1000);
				Thread.sleep(time);     //线程休眠
				System.out.println("正在执行线程"+Thread.currentThread().getName()); //获取当前线程名
			}
		}catch(InterruptedException e){   //中断异常
			e.printStackTrace();
		}
	}
}
