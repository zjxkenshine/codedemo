package Chapter1.Thread;

public class Thread1_26_2 extends Thread{
	//线程优先级的继承性
	public void run(){
		System.out.println("thread2的priority="+this.getPriority());
	}
}
