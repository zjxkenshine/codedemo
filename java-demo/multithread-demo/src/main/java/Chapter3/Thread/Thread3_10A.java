package Chapter3.Thread;

import Chapter3.Object.P3_10;

public class Thread3_10A extends Thread{
	//生产者线程
	
	private P3_10 p;
	
	public Thread3_10A(P3_10 p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			p.setValue();
		}
	}

}
