package Chapter1.Thread;

public class Thread1_7 extends Thread{
	//安全数据共享，线程安全
	private int count=6;
	
	//for循环同步，不能用For循环
	synchronized public void run(){     //synchronized实现线程安全
		super.run();
		count--;
		System.out.println("由线程"+this.currentThread().getName()+"计算，count="+count);
	}
}
