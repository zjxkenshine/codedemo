package Chapter3.Thread;

public class Thread3_05Notify extends Thread{
	//���÷���notifyһ��ֻ��֪ͨһ���̲߳����ѣ�notifyAll֪ͨ����
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
			
		/*lock.notify();                //����ʹ��֪ͨ�����߳�
		 * lock.notify();
		 * lock.notify();
		 */
			
		//	lock.notifyAll();           //ʹ��notifyAll����
		}
	}

}
