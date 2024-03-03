package Chapter3.Thread;

public class Thread3_05Notify extends Thread{
	//调用方法notify一次只能通知一个线程并唤醒，notifyAll通知所有
	private Object lock;
	public Thread3_05Notify(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
				
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (lock) {
			lock.notify();
			
		/*lock.notify();                //连续使用通知所有线程
		 * lock.notify();
		 * lock.notify();
		 */
			
		//	lock.notifyAll();           //使用notifyAll方法
		}
	}

}
