package Chapter3.Thread;

import Chapter3.Object.C3_10;

public class Thread3_10B extends Thread{
	//消费者线程
	 
	private C3_10 c;
	
	public Thread3_10B(C3_10 c) {
		// TODO Auto-generated constructor stub
		this.c=c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			c.getValue();
		}
	}
	

}
