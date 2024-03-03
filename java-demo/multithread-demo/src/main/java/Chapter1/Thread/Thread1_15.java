package Chapter1.Thread;

public class Thread1_15 extends Thread{
	//线程停止：Thread.interrupt()停止标记，无法停止线程
	
	public void run(){
		super.run();
		for(int i=0;i<20;i++){
			System.out.println("i="+(i+1));
		}
	}
}
