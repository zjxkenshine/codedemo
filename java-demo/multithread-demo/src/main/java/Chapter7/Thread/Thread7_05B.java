package Chapter7.Thread;

public class Thread7_05B extends Thread{
	//�̶߳�������߳��飺һ������
	
	@Override
	public void run() {
		super.run();
		
		try{
			
			while(!Thread.currentThread().isInterrupted()){
				System.out.println("�߳����ƣ�"+Thread.currentThread().getName());
			}
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
