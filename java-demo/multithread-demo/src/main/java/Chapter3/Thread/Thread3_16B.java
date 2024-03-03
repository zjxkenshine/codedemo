package Chapter3.Thread;


import java.io.PipedReader;

import Chapter3.Object.Read3_16;

public class Thread3_16B extends Thread{
	
	private Read3_16 re;
	private PipedReader input;
	
	public Thread3_16B(Read3_16 re,PipedReader input) {
		// TODO Auto-generated constructor stub
		this.re=re;
		this.input=input;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		re.readMethod(input);
	}


}
