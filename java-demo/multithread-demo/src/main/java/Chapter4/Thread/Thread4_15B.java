package Chapter4.Thread;

import Chapter4.Object.Service4_15;

public class Thread4_15B extends Thread{
	//����awaitUntil()��ʹ��
	
	private Service4_15 ser;
	
	public Thread4_15B(Service4_15 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.notifyMethod();
	}

}
