package Chapter2.Thread;

import Chapter2.Object.Object2_15_1;

public class Thread2_15_1A extends Thread{
	//�������this������Ϊ�������������
	
	private Object2_15_1 obj;
	
	public Thread2_15_1A(Object2_15_1 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		super.run();
		obj.setUsernamePassword("a", "aaa");
	}

}
