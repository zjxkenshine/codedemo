package Chapter4.Thread;

import Chapter4.Object.Service4_17;

public class Thread4_17A extends Thread{
	//ReentrantReadWriteLock���ʹ�ã�����������
	
	private Service4_17 ser;
	
	public Thread4_17A(Service4_17 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.read();
	}

}
