package Chapter1.Thread;

public class Thread1_21 extends Thread{
	//interrupt()与return结合使用实现停止线程（可以使用）
	
	public void run(){
		while(true){
			if(this.isInterrupted()){
				System.out.println("线程停止了");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}
