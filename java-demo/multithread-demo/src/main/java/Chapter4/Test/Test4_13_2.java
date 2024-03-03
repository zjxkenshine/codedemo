package Chapter4.Test;

import Chapter4.Object.Service4_13_2;

public class Test4_13_2 {
	//tryLock()方法
	
	/**
	 * 方法boolean tryLock()的作用是【仅在调用时】锁未被另一个线程持有时才获取该锁
	 * 锁未被占则同步，否则不同步，不会产生阻塞
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_13_2 ser=new Service4_13_2();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ser.Method();
			}
		};
		
		Thread t1=new Thread(run);
		t1.setName("AAAA");
		t1.start();
		Thread.sleep(2000);
		Thread t2=new Thread(run);
		t2.setName("BBBB");
		t2.start();
		
		
	}
	
	

}
