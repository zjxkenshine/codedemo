package Chapter2.Thread;

import Chapter2.Object.Object2_12;

public class Thread2_12B extends Thread{
	//ͬ�������һ��ͬ��һ���첽
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
