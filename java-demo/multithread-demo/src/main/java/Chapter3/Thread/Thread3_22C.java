package Chapter3.Thread;

public class Thread3_22C extends Thread{
   	// join(long)与sleep(long)的区别
	Thread3_22B tb=new Thread3_22B();
	
	public Thread3_22C(Thread3_22B tb) {
		// TODO Auto-generated constructor stub
		this.tb=tb;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		tb.bService();
	}

}
