package Chapter7.Thread;

public class ThreadGroup7_17_2 extends ThreadGroup{
	//�߳����ڴ����쳣
	
	public ThreadGroup7_17_2(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	//����uncaughtException(Thread t, Throwable e)�е�t�ǳ����쳣���̶߳���
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		super.uncaughtException(t, e);
		this.interrupt();
	}
	

}
