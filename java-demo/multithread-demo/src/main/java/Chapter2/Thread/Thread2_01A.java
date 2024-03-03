package Chapter2.Thread;

import Chapter2.Object.Object2_01;

public class Thread2_01A extends Thread{
	//方法内的变量为线程安全
	
	private Object2_01 obj;
	public Thread2_01A(Object2_01 obj){
		super();
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.addI("a");
	}
}
