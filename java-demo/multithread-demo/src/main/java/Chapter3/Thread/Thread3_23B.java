package Chapter3.Thread;

public class Thread3_23B extends Thread{
	//����join()����Ĵ�����ǰ���У���������
	
	@Override
	synchronized public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			System.out.println("begin b ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("end b ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
