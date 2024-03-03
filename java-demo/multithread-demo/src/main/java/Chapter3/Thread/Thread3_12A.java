package Chapter3.Thread;


import Chapter3.Object.P3_12;

public class Thread3_12A extends Thread{
	
	private P3_12 p;
	public Thread3_12A( P3_12 p) {
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
