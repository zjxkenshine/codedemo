package Chapter3.Thread;

public class Thread3_20B extends Thread{
	//����join��interrupt�쳣
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try{
			Thread3_20A a=new Thread3_20A();
			a.start();
			a.join();
			System.out.println("�߳�B��run end ����ӡ");
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("�߳�B��run catch ����ӡ");
			e.printStackTrace();
		}
	}

}
