package Chapter1.Thread;

public class Thread1_8 extends Thread{
	//i++,i--与println(同步方法)连用，出现另一种异常
	private int i=5;
	

	 public void run(){            //解决方法，加上synchronized
		super.run();

		System.out.println("由线程"+this.currentThread().getName()+"计算，i="+(i--));  //i--在println方法外执行
	}
}
