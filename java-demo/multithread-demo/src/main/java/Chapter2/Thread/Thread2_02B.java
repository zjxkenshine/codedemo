package Chapter2.Thread;

import Chapter2.Object.Object2_02;

public class Thread2_02B extends Thread{
	//ʵ���������̰߳�ȫ
	private Object2_02 obj;
	public Thread2_02B(Object2_02 obj){
		super();
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.addI("b");
	}
}
