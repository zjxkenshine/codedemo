package Chapter4.Test;

import Chapter4.Object.Service4_11_1;

public class Test4_11_1 {
	//hasQueueThread(),hasQueueThreads()
	
	/**1.����boolean hasQueueThread(Thread thread)�������ǲ�ѯָ���߳�thread�Ƿ����ڵȴ���ȡ����
	 * 
	 * 2.����boolean hasQueueThreads()�����ǲ�ѯ�Ƿ����߳����ڵȴ���ȡ����
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
		//1�߳�һֱ���ڳ�˯״̬
		System.out.println(ser.lock.hasQueuedThread(t1));
		System.out.println(ser.lock.hasQueuedThread(t2));
		System.out.println(ser.lock.hasQueuedThreads());
		
	}

}
