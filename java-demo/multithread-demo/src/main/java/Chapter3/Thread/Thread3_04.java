package Chapter3.Thread;

import Chapter3.Object.Object3_04;

public class Thread3_04 extends Thread{
	//interrupt��������wait����
	
	private Object lock;
	public Thread3_04(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Object3_04 obj=new Object3_04();
		obj.Method(lock);
	}

}
