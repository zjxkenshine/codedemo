package Chapter2.Thread;

import Chapter2.Object.Object2_22_1;

public class Thread2_22_1B extends Thread{
	// ��String�����ص����ԡ���synchronized(String)����������
	
	private Object2_22_1 obj;
	
	public Thread2_22_1B(Object2_22_1 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.print("AAA");
	}
	

}
