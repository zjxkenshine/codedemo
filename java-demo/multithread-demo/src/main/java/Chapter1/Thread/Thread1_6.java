package Chapter1.Thread;

public class Thread1_6 extends Thread{
	//数据共享：非线程安全，两个线程同时对数据处理
	private int count=6;
	
	//for循环同步，不能用For循环
	public void run(){
		super.run();
		count--;
		System.out.println("由线程"+this.currentThread().getName()+"计算，count="+count);
	}
}
