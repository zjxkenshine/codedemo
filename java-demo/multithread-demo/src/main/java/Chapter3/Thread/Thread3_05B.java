package Chapter3.Thread;

import Chapter3.Object.Object3_05;

public class Thread3_05B extends Thread{
	//���÷���notifyһ��ֻ��֪ͨһ���̲߳����ѣ�notifyAll֪ͨ����
	private Object lock;
	public Thread3_05B(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
				
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (lock) {
		    Object3_05 obj=new Object3_05();
		    obj.Method1(lock);
		}
	}


}
