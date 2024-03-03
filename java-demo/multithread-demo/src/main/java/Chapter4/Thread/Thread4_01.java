package Chapter4.Thread;


import Chapter4.Object.Service4_01;

public class Thread4_01 extends Thread{
	//使用ReentratLock实现同步：测试1
	private Service4_01 ser=new Service4_01();
	
	public Thread4_01(Service4_01 ser) {
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
