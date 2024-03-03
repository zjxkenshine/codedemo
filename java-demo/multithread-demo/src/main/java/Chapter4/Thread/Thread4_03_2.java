package Chapter4.Thread;


import Chapter4.Object.Service4_03_2;

public class Thread4_03_2 extends Thread{
	private Service4_03_2 ser=new Service4_03_2();
	
	public Thread4_03_2(Service4_03_2 ser) {
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
