package Chapter3.Thread;

public class Thread3_22A extends Thread{
	// join(long)��sleep(long)������
	
	private Thread3_22B tb;
	
	public Thread3_22A(Thread3_22B tb) {
		// TODO Auto-generated constructor stub
		this.tb=tb;
	}
	
	//sleep���ͷ���
	/*@Override
	public void run() {
		synchronized (tb) {
	
			// TODO Auto-generated method stub
			super.run();
			try{
				tb.start();
				Thread.sleep(6000);    //���ͷ���
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		}
	}*/
	
	//join(long)�ͷ���
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		synchronized (tb) {
			
			// TODO Auto-generated method stub
			super.run();
			try{
				tb.start();
				tb.join(6000);
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		}
	}

}
