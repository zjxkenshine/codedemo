package Chapter3.Thread;

public class Thread3_19 extends Thread{
	//使用join()方法
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int seconds=(int)(Math.random()*10000);
		System.out.println(seconds);
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
