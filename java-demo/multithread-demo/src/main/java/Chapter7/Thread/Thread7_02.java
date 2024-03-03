package Chapter7.Thread;

public class Thread7_02 extends Thread{
	//ÑéÖ¤TIMED_WAITING×´Ì¬
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println("begin sleep");
			Thread.sleep(10000);
			System.out.println("end sleep");
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
