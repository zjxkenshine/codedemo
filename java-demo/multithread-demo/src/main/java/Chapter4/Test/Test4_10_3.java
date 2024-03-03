package Chapter4.Test;

import Chapter4.Object.Service4_10_3;

public class Test4_10_3 {
	//getWaitQueueLength(Condition condition)方法
	
	/**getWaitQueueLength(Condition condition)方法是返回等待与此锁定相关的给的条件condition的线程估计数
	 * 返回执行了此condition的await方法而没有释放的线程的个数
	 * 如有5个线程，每个线程执行同一个condition的await，那么返回的是5
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_10_3 ser=new Service4_10_3();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.WaitMethod();
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
		ser.SingalMethod();
	}

}
