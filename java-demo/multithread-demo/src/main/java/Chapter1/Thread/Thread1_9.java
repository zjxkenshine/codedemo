package Chapter1.Thread;

public class Thread1_9 extends Thread{
	//currentThread()方法：返回代码段正在被哪个线程调用
	
	public Thread1_9(){
		System.out.println("构造方法由线程"+Thread.currentThread().getName()+"执行");
	}
	
	public void run(){
		System.out.println("run方法由线程"+Thread.currentThread().getName()+"执行");
	}
	
	
}
