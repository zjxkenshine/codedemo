package Chapter4.Thread;

import Chapter4.Object.Service4_18;

public class Thread4_18A extends Thread{
	//ReentrantReadWriteLock类的使用：【写写互斥】
	
	private Service4_18 ser;
	
	public Thread4_18A(Service4_18 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.write();
	}

}
