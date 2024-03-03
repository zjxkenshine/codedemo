package Chapter3.Thread;

import Chapter3.Object.Add3_08;

public class Thread3_08A extends Thread{
	private Add3_08 a;
	
	public Thread3_08A(Add3_08 a){
		this.a=a;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		a.add();
	}

}
