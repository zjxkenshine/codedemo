package Chapter7.Thread;

public class ThreadGroup7_18 extends ThreadGroup{
	//�߳��쳣����Ĵ���
	
	public ThreadGroup7_18(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		super.uncaughtException(t, e);
		System.out.println("�߳�����쳣����");
		e.printStackTrace();
	}

}
