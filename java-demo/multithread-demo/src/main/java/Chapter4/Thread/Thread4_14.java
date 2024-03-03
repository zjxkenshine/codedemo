package Chapter4.Thread;


import Chapter4.Object.Service4_14;

public class Thread4_14 extends Thread{
	//方法awaitUninterruptibly()的使用
	
	private Service4_14 ser;
	
	public Thread4_14( Service4_14 ser) {
		// TODO Auto-generated constructor stub
		this.ser=ser;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		ser.testMethod();
	}
	

}
