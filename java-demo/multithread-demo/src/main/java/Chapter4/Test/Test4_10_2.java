package Chapter4.Test;

import Chapter4.Object.Service4_10_2;

public class Test4_10_2 {
	//getQueueLength()方法
	
	/**getQueueLength()方法的作用是返回正在等待此锁的线程估计数， 如果有5个线程，
	 * 一个线程首先执行await方法，那么调用getQueueLength方法的返回值是4，
	 * 那么说明有4个线程在同时等待lock释放
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_10_2 ser=new Service4_10_2();
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.TestMethod();
				
			}
		};
		Thread[] tl=new Thread[10];
		for(int i=0;i<10;i++){
			tl[i]=new Thread(runn);
		}
		for(int i=0;i<10;i++){
			tl[i].start();
		}
		Thread.sleep(2000);
		System.out.println("有"+ser.lock.getQueueLength()+"个线程在等待锁");
	}

}
