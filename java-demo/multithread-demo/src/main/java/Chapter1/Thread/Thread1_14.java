package Chapter1.Thread;

public class Thread1_14 extends Thread{
	//getId()方法，获取线程的唯一表示
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+","+Thread.currentThread().getId());
	}
}
