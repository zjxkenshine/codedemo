package Chapter1.Thread;

public class Thread1_12 extends Thread {
	//isAlive()的复杂情况，this.isAlive()
	
	public Thread1_12(){
		System.out.println("thread1_12构造方法开始");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("thread.currentThread.isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("thread1_12构造方法结束");
	}
	
	public void run(){
		System.out.println("run方法开始");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("thread.currentThread.isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("run方法结束");
	}
	
}
