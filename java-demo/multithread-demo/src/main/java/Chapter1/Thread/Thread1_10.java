package Chapter1.Thread;

public class Thread1_10 extends Thread{
	//this.getName()与thread.currentThread.getName()的区别
	//this.getName()指向正在执行的线程
	
	public Thread1_10(){
		System.out.println("thread1_10构造方法开始");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("thread1_10构造方法结束");
	}
	
	public void run(){
		System.out.println("run方法开始");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("run方法结束");
	}
	
}
