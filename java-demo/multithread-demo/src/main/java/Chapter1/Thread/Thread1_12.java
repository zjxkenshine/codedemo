package Chapter1.Thread;

public class Thread1_12 extends Thread {
	//isAlive()�ĸ��������this.isAlive()
	
	public Thread1_12(){
		System.out.println("thread1_12���췽����ʼ");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("thread.currentThread.isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("thread1_12���췽������");
	}
	
	public void run(){
		System.out.println("run������ʼ");
		System.out.println("thread.currentThread.getName()="+Thread.currentThread().getName());
		System.out.println("thread.currentThread.isAlive()="+Thread.currentThread().isAlive());
		System.out.println("this.getName()="+this.getName());
		System.out.println("this.isAlive()="+this.isAlive());
		System.out.println("run��������");
	}
	
}
