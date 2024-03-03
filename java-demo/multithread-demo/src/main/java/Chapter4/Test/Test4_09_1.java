package Chapter4.Test;

import Chapter4.Object.Service4_09;

public class Test4_09_1 {
	//公平锁
	
	/**1.锁分为公平锁与非公平锁，公平锁表示线程获取锁的顺序按照线程加锁（start）的顺序进行分配，先到先得，FIFO
	 *    非公平锁就是获取锁的抢占机制，随机获得锁，先来的不一定先得到锁
	 *    
	 * 2.运行结果：有部分会出错？基本按顺序打印
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		final Service4_09 ser=new Service4_09(true);             //公平锁
		
		Runnable runn=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("********线程"+Thread.currentThread().getName()+"运行了（加锁了）");
				ser.Method();
				
			}
			
		};
		Thread[] th=new Thread[10];
		
		for(int i=0;i<10;i++){
			th[i]=new Thread(runn);
		}
		
        for(int i=0;i<10;i++){
        	th[i].start();
		}
		
	}

}
