package Chapter7.Thread;

public class Thread7_10 extends Thread{
	//线程组内的线程批量停止
	
	public Thread7_10(ThreadGroup tg,String name) {
		// TODO Auto-generated constructor stub
		super(tg,name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("ThreadName"+Thread.currentThread().getName()+" 开始死循环");
		while(!this.isInterrupted()){
		}
		System.out.println("ThreadName"+Thread.currentThread().getName()+" 死循环结束了");
	}

}
