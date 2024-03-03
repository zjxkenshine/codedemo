package Chapter4.Thread;

import Chapter4.Object.Service4_04;

public class Thread4_04 extends Thread{
	//正确使用Condition实现等待/通知
	
	private Service4_04 ser=new Service4_04();
	
	public Thread4_04(Service4_04 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.await();
	}

}
