package Chapter3.Thread;

import Chapter3.Object.Substract3_08;

public class Thread3_08B extends Thread{
    private Substract3_08 b;
	
	public Thread3_08B(Substract3_08 b){
		this.b=b;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		b.Subtract();
	}

}
