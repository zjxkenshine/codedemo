package Chapter2.Thread;

import Chapter2.Object.Object2_14;

public class Thread2_14B extends Thread{
	//��֤synchronized�������������ǰ�����
	
private Object2_14 obj=new Object2_14();
	
	public Thread2_14B(Object2_14 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		
	}
	
	public void run(){
		super.run();
		obj.MethodB();
	}

}
