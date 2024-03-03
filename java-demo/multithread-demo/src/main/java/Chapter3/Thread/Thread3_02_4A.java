package Chapter3.Thread;

import Chapter3.Object.Object3_02_4;

public class Thread3_02_4A extends Thread{
	private Object obj=new Object();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			synchronized (obj) {
				if(Object3_02_4.size()!=5){
					System.out.println("wait begin "+System.currentTimeMillis());
					obj.wait();
					System.out.println("wait end "+System.currentTimeMillis());
				}
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public Thread3_02_4A(Object obj) {
		// TODO Auto-generated constructor stub
		this.obj=obj;
	}

}
