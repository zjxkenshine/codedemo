package Chapter4.Thread;

import Chapter1.Thread.runnable1_4;
import Chapter4.Object.Service4_05;

public class Thread4_05A extends Thread{
	//ʹ�ö��Conditionʵ��֪ͨ�����߳�ʱ�Ĵ����÷�
	
	private Service4_05 ser=new Service4_05();
	
	public Thread4_05A(Service4_05 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.awaitA();
	}

	

}
