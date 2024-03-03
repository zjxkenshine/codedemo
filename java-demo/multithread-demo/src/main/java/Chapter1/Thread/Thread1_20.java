package Chapter1.Thread;

public class Thread1_20 extends Thread {
	//stop()方法暴力停止（不推荐使用）
	private int i=0;
	
	public void run(){
		try{
			while(true){
				i++;
				System.out.println("i="+i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
