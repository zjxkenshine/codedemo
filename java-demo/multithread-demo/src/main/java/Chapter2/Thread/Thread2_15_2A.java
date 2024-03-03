package Chapter2.Thread;

import Chapter2.Object.Object2_15_2;

public class Thread2_15_2A extends Thread{
	//将任意非this对象作为【对象监视器】
	

	private Object2_15_2 obj;
	
	public Thread2_15_2A(Object2_15_2 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		super.run();
		obj.MethodA();
	}

	

}
