package Chapter1.Thread;

public class Thread1_10 extends Thread{
	//this.getName()��thread.currentThread.getName()������
	//this.getName()ָ������ִ�е��߳�
	
	public Thread1_10(){
		System.out.println("thread1_10���췽����ʼ");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("thread1_10���췽������");
	}
	
	public void run(){
		System.out.println("run������ʼ");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("this.getName()="+this.getName());
		System.out.println("run��������");
	}
	
}
