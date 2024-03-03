package Chapter3.Thread;

public class Thread3_20C extends Thread{
	//方法join与interrupt异常
	
	private Thread3_20B tb;
	
	public Thread3_20C(Thread3_20B tb) {
		// TODO Auto-generated constructor stub
		this.tb=tb;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		tb.interrupt();
	}
	

	
	

}
