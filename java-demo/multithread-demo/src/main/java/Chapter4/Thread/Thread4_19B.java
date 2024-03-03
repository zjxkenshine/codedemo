package Chapter4.Thread;

import Chapter4.Object.Service4_19;

public class Thread4_19B extends Thread{
	//ReentrantReadWriteLock类的使用：【读写互斥】
	
private Service4_19 ser;
	
	public Thread4_19B(Service4_19 ser) {
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
