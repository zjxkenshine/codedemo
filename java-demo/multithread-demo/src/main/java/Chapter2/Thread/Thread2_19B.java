package Chapter2.Thread;

import Chapter2.Object.Object2_19;

public class Thread2_19B extends Thread{
	//synchronized(�����this����x)������֤3��       �������߳�ִ��x�����е�synchronized(this)ͬ�������ʱ��ͬ��Ч��
	private Object2_19 obj;
	
	public Thread2_19B(Object2_19 obj) {
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
