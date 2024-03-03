package Chapter7.Thread;

public class ThreadGroup7_17_2 extends ThreadGroup{
	//线程组内处理异常
	
	public ThreadGroup7_17_2(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	//方法uncaughtException(Thread t, Throwable e)中的t是出现异常的线程对象
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		super.uncaughtException(t, e);
		this.interrupt();
	}
	

}
