package Chapter3.Test;

public class Test3_06 {
	//wait(long)方法的使用
	
	/**带一个参数的wait(long)方法的功能是等待某一时间内是否有线程对锁进行唤醒，
	 * 超过这个时间则会自动唤醒。
	 * 
	 */
	static private Object lock=new Object();
	
	static private Runnable runnable1=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				synchronized (lock) {
					System.out.println("wait begin time="+System.currentTimeMillis());
					lock.wait(5000);
					System.out.println("wait end time="+System.currentTimeMillis());
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		
	};
	
	
	static private Runnable runnable2=new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
				synchronized (lock) {
					System.out.println("notify begin time="+System.currentTimeMillis());
					lock.notify();
					System.out.println("notify end time="+System.currentTimeMillis());
				}
		}
	};
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(runnable1);
		t1.start();
		Thread.sleep(3000);            //在3秒时被唤醒
		Thread t2=new Thread(runnable2);
		t2.start();
	}
	

}
