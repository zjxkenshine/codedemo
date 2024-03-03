package Chapter4.Test;

import Chapter4.Object.Service4_11_1;

public class Test4_11_1 {
	//hasQueueThread(),hasQueueThreads()
	
	/**1.方法boolean hasQueueThread(Thread thread)的作用是查询指定线程thread是否正在等待获取此锁
	 * 
	 * 2.方法boolean hasQueueThreads()作用是查询是否有线程正在等待获取此锁
	 * @throws InterruptedException 
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_11_1 ser=new Service4_11_1();
		
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.waitMethod();
				
			}
		};
		Thread t1=new Thread(runn);
		t1.start();
		Thread.sleep(500);
		Thread t2=new Thread(runn);
		t2.start();
		Thread.sleep(500);
		//1线程一直处在沉睡状态
		System.out.println(ser.lock.hasQueuedThread(t1));
		System.out.println(ser.lock.hasQueuedThread(t2));
		System.out.println(ser.lock.hasQueuedThreads());
		
	}

}
