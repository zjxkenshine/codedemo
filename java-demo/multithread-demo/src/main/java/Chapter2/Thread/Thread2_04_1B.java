package Chapter2.Thread;

import Chapter2.Object.Object2_04_1;

public class Thread2_04_1B extends Thread{
	//synchronized方法锁的是这个对象而非方法
	
	private Object2_04_1 obj;
	
	public Thread2_04_1B(Object2_04_1 obj) {
		super();
		this.obj=obj;
	}

	public void run() {
		super.run();
		obj.methodA();
	}
}
