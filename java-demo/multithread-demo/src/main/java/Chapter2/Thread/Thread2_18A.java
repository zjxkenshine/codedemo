package Chapter2.Thread;

import Chapter2.Object.Object2_18;
import Chapter2.Object.Service2_18;

public class Thread2_18A extends Thread{
	//synchronized(�����this����x)������֤2��       �������߳�ִ��x�����е�synchronizedͬ������ʱ��ͬ��Ч��
	
	private Object2_18 obj;
	private Service2_18 serv;
	
	public Thread2_18A(Service2_18 serv,Object2_18 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		this.serv=serv;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			serv.MethodB(obj);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
