package Chapter2.Thread;

import Chapter2.Object.Object2_15_2;

public class Thread2_15_2A extends Thread{
	//�������this������Ϊ�������������
	

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
