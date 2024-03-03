package Chapter3.Thread;

import java.io.PipedInputStream;

import Chapter3.Object.Read3_15;

public class Thread3_15B extends Thread{
	//管道输入流线程
	
	private Read3_15 re;
	private PipedInputStream input;
	
	public Thread3_15B(Read3_15 re,PipedInputStream input) {
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
