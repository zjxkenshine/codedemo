package Chapter3.Thread;

import Chapter3.Object.C3_12;

public class Thread3_12B extends Thread{
	
	private C3_12 c;
	public Thread3_12B( C3_12 c) {
		// TODO Auto-generated constructor stub
		this.c=c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
	 		c.popService();
		}
	}

}
