package Chapter2.Thread;

import Chapter2.Object.Object2_18;

public class Thread2_18B extends Thread{
	//synchronized(�����this����x)������֤2��       �������߳�ִ��x�����е�synchronizedͬ������ʱ��ͬ��Ч��
	
	private Object2_18 obj;
	
	public Thread2_18B(Object2_18 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		obj.MethodA();
	}
	
}
