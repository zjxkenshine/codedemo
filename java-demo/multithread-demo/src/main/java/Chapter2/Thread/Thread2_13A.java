package Chapter2.Thread;

import Chapter2.Object.Object2_13;

public class Thread2_13A extends Thread{
	//synchronized�������ͬ����
	
	private Object2_13 obj;
	
	public Thread2_13A(Object2_13 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		super.run();
		obj.MethodA();
	}
	

}
