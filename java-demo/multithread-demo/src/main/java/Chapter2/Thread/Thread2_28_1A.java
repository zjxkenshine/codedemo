package Chapter2.Thread;

import Chapter2.Object.Object2_28_1;

public class Thread2_28_1A extends Thread{
	//������ĸı�
	
	private Object2_28_1 obj;
	
	public Thread2_28_1A(Object2_28_1 obj){
		this.obj=obj;
	}
	
	public void run(){
		super.run();
		obj.testMethod();
	}

}
