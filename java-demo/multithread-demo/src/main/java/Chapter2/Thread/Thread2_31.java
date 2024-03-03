package Chapter2.Thread;

public class Thread2_31 extends Thread{
	//volatile解决异步死循环
	
	private boolean isRunning=true;                  //在_server运行环境下死循环
	
//	volatile private boolean isRunning=true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("进入run了!");
		while(isRunning){
			System.out.println("123");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("线程被停止了!");
	}
	

	
	
}
