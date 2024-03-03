package Chapter3.Thread;

import java.io.PipedOutputStream;

import Chapter3.Object.Write3_15;

public class Thread3_15A extends Thread{
	//管道输出流线程
	
	private Write3_15 write;
	private PipedOutputStream out;
	
	public Thread3_15A( Write3_15 write ,PipedOutputStream out) {
		// TODO Auto-generated constructor stub
		this.out=out;
		this.write=write;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		write.writeMethod(out);
	}

}
