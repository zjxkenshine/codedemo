package Chapter2.Thread;

public class Thread2_31 extends Thread{
	//volatile����첽��ѭ��
	
	private boolean isRunning=true;                  //��_server���л�������ѭ��
	
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
		System.out.println("����run��!");
		while(isRunning){
			System.out.println("123");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�̱߳�ֹͣ��!");
	}
	

	
	
}
