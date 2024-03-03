package Chapter3.Thread;

import Chapter3.Object.P3_11;

public class Thread3_11A extends Thread{
	//一生产与一消费：【操作栈】
	
	private P3_11 p;
	public Thread3_11A( P3_11 p) {
		// TODO Auto-generated constructor stub
		this.p=p;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
	 		p.pushService();
		}
	}

}
