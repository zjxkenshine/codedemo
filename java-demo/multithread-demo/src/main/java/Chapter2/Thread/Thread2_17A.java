package Chapter2.Thread;

import Chapter2.Object.Object2_17;
import Chapter2.Object.Service2_17;

public class Thread2_17A extends Thread{
	//synchronized(�����this����x)������֤1��      ����߳�ͬʱִ��synchronized(x){}ͬ�������ʱ��ͬ��Ч��
	
	private Object2_17 obj;
	private Service2_17 serv;
	
	public Thread2_17A(Service2_17 serv,Object2_17 obj) {
		// TODO Auto-generated constructor stub
		super();
		this.obj=obj;
		this.serv=serv;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		serv.MethodA(obj);
	}

}
