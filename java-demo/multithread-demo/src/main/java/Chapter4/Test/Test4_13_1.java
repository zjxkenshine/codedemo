package Chapter4.Test;

import Chapter4.Object.Service4_13_1;

public class Test4_13_1 {
	//lockInterruptibly()方法
	
	/**方法void lockInterruptibly()的作用是：如果当前线程未被中断，则获取锁定，如果已经被中断则报异常
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		final Service4_13_1 ser=new Service4_13_1();
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ser.TestMethod();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t1=new Thread(run);
		t1.setName("AAA");
		t1.start();
		Thread.sleep(500);
		Thread t2=new Thread(run);
		t2.setName("BBB");
		t2.start();
		t2.interrupt();   //b线程中断时会报错
		System.out.println("main end");
	}

}
