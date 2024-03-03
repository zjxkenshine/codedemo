package Chapter1.Thread;

public class Thread1_11 extends Thread{
	//isAlive()方法：判断线程是否处于活动状态
	public void run(){
		System.out.println("run="+this.isAlive());
	}
}
