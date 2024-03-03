package Chapter3.Thread;

import Chapter3.Object.P3_09;

public class Thread3_09A extends Thread{
	private P3_09 P;
	
	public Thread3_09A(P3_09 P){
		this.P=P;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			P.setValue();
		}
	}
  
}
