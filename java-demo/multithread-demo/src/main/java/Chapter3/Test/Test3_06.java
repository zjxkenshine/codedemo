package Chapter3.Test;

public class Test3_06 {
	//wait(long)������ʹ��
	
	/**��һ��������wait(long)�����Ĺ����ǵȴ�ĳһʱ�����Ƿ����̶߳������л��ѣ�
	 * �������ʱ������Զ����ѡ�
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
		Thread.sleep(3000);            //��3��ʱ������
		Thread t2=new Thread(runnable2);
		t2.start();
	}
	

}
