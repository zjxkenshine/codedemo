package Chapter1.Thread;

public class Thread1_17 extends Thread {
	//this.isInterrupted():非静态方法，测试线程对象（非当前线程）是否中断，但不清除中断状态标记
	public void run(){
		super.run();
		for(int i=0;i<200;i++){
			System.out.println("i="+(i+1));
		}
	}

}
