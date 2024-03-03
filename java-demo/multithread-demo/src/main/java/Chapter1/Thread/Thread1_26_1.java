package Chapter1.Thread;

public class Thread1_26_1 extends Thread{
	//线程优先级的继承性
	public void run(){
		System.out.println("thread1 的 priority="+this.getPriority());
		Thread1_26_2 thread2=new Thread1_26_2();
		thread2.start();
	}

}
