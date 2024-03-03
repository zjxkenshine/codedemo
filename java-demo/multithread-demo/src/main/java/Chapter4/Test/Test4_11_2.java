package Chapter4.Test;

import Chapter4.Object.Service4_11_2;

public class Test4_11_2 {
	//hasWaiters(Condition condition)方法
	
	/**
	 * boolean hasWaiters(Condition condition)方法作用是查询是否有线程在等待与此锁定相关的condition条件
	 * @throws InterruptedException 
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_11_2 ser=new Service4_11_2();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.waitMethod();
			}
		};
		Thread[] tlist=new Thread[10];
		
		for(int i=0;i<10;i++){
			tlist[i]=new Thread(run);
		}
		
		for(int i=0;i<10;i++){
			tlist[i].start();
		}
		Thread.sleep(2000);
		ser.notifyMethod();
	}

}
