package Chapter2.Thread;

import Chapter2.Object.Object2_19;
import Chapter2.Object.Service2_19;

public class Thread2_19A extends Thread{
	//synchronized(�����this����x)������֤3��       �������߳�ִ��x�����е�synchronized(this)ͬ�������ʱ��ͬ��Ч��
	
	private Object2_19 obj;
	private Service2_19 serv;
	
	public Thread2_19A(Service2_19 serv,Object2_19 obj) {
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
