package Chapter2.Thread;

import Chapter2.Object.Object2_28_1;

public class Thread2_28_1B extends Thread{
	//锁对象的改变

	private Object2_28_1 obj;
	
	public Thread2_28_1B(Object2_28_1 obj){
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.testMethod();
	}
}
