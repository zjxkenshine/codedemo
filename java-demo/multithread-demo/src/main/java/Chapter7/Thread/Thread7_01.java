package Chapter7.Thread;

public class Thread7_01 extends Thread{
	//验证NEW,RUNNABLE和TERMINATED状态
	
	public Thread7_01() {
		// TODO Auto-generated constructor stub
		System.out.println("构造方法中的状态："+Thread.currentThread().getState());          //这里显示的是main线程的状态
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("run方法中的状态："+Thread.currentThread().getState());
	}

}
