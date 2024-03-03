package Chapter4.Thread;


import Chapter4.Object.Service4_03_1;

public class Thread4_03_1 extends Thread{
	//使用Condition实现等待/通知：错误的用法及解决
	private Service4_03_1 ser=new Service4_03_1();
	
	public Thread4_03_1(Service4_03_1 ser) {
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
