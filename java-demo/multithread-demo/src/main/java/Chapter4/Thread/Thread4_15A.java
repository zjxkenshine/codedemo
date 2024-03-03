package Chapter4.Thread;

import Chapter4.Object.Service4_15;

public class Thread4_15A extends Thread{
	//方法awaitUntil()的使用
	
	private Service4_15 ser;
	
	public Thread4_15A(Service4_15 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.waitMethod();
	}

}
