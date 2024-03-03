package Chapter2.Thread;

import Chapter2.Object.Object2_12;

public class Thread2_12B extends Thread{
	//同步代码块一半同步一半异步
private Object2_12 obj;
	
	public Thread2_12B(Object2_12 obj){
		super();
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.longTask();
	}
}
