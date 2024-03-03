package Chapter1.Thread;

public class Thread1_16 extends Thread{
	//this.interrupted():判断当前线程是否中断，执行后清除中断标记
	
	public void run(){
		super.run();
		for(int i=0;i<200;i++){
			System.out.println("i="+(i+1));
		}
	}

}
