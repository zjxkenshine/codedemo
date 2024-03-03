package Chapter3.Thread;

import Chapter3.Object.Object3_03_2;

public class Thread3_03_2C extends Thread{
	//notify()Ëø²»ÊÍ·Å
	private Object lock;
	public Thread3_03_2C(Object lock) {
		// TODO Auto-generated constructor stub
		this.lock=lock;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Object3_03_2 obj=new Object3_03_2();
		obj.Method2(lock);
	}

}
