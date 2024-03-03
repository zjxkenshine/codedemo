package Chapter3.Thread;

public class Thread3_22B extends Thread{
	// join(long)��sleep(long)������
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println("b begin time="+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("b end time="+System.currentTimeMillis());
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public void bService(){
		System.out.println("��ӡ��bServer time="+System.currentTimeMillis());
	}

}
