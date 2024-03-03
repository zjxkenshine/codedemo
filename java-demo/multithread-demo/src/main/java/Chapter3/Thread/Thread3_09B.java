package Chapter3.Thread;

import Chapter3.Object.C3_09;

public class Thread3_09B extends Thread{
private C3_09 C;
	
	public Thread3_09B(C3_09 C){
		this.C=C;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			C.getValue();
		}
	}

}
